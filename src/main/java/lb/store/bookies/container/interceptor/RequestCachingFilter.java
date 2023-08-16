package lb.store.bookies.container.interceptor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class RequestCachingFilter extends OncePerRequestFilter {
    private final Configuration jsonPathConfiguration;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String contentType = request.getHeader("Content-Type");
        if (contentType != null && contentType.equals("application/json")) {
            CachedHttpServletRequest cachedHttpServletRequest = new CachedHttpServletRequest(request);
            ContentCachingResponseWrapper contentCachingResponseWrapper = new ContentCachingResponseWrapper(response);
            try {
                logRequest(cachedHttpServletRequest);
                filterChain.doFilter(cachedHttpServletRequest, contentCachingResponseWrapper);
            } finally {
                logResponse(contentCachingResponseWrapper);
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }

    private void logRequest(CachedHttpServletRequest cachedHttpServletRequest) throws IOException {
        String requestBody = new String(cachedHttpServletRequest.getInputStream().readAllBytes());
        String method = cachedHttpServletRequest.getMethod();
        String requestURI = cachedHttpServletRequest.getRequestURI();
        log.info("==============================");
        log.info(">> REQUEST PATH: [{}] {}", method, requestURI);
        log.info(">> REQUEST BODY: \n{}", formatJson(mask(requestBody)));
        log.info("==============================");
    }

    private void logResponse(ContentCachingResponseWrapper contentCachingResponseWrapper) throws IOException {
        String responseBody = new String(contentCachingResponseWrapper.getContentAsByteArray());
        int status = contentCachingResponseWrapper.getStatus();
        log.info("==============================");
        log.info("<< RESPONSE STATUS: {}", status);
        log.info("<< RESPONSE BODY: \n{}", formatJson(responseBody));
        log.info("==============================");
        contentCachingResponseWrapper.copyBodyToResponse();
    }

    private String mask(String requestBody) {
        if (requestBody == null || requestBody.isBlank()) return "";
        DocumentContext documentContext = JsonPath.parse(requestBody, jsonPathConfiguration);
        if (documentContext.read("$.password", String.class) != null)
            return documentContext.set("$.password", "******").jsonString();
        return requestBody;
    }

    private String formatJson(String requestBody) throws JsonProcessingException {
        if (requestBody == null || requestBody.isBlank()) return "";
        ObjectMapper mapper = new ObjectMapper();
        Object object = mapper.readValue(requestBody, Object.class);
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
    }
}