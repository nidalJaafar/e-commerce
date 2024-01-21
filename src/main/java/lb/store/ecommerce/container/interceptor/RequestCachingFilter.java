package lb.store.ecommerce.container.interceptor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lb.store.ecommerce.container.exception.response.ExceptionResponse;
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

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String contentType = request.getHeader("Content-Type");
        if (contentType == null) {
            returnErrorResponse(response);
            return;
        }
        if (contentType.equals("application/json")) {
            CachedHttpServletRequest cachedHttpServletRequest = new CachedHttpServletRequest(request);
            ContentCachingResponseWrapper contentCachingResponseWrapper = new ContentCachingResponseWrapper(response);
            try {
                logRequestJson(cachedHttpServletRequest);
                filterChain.doFilter(cachedHttpServletRequest, contentCachingResponseWrapper);
            } finally {
                logResponseJson(contentCachingResponseWrapper);
            }
        } else {
            logRequest(request);
            filterChain.doFilter(request, response);
            logResponse(response);
        }
    }

    private void returnErrorResponse(HttpServletResponse response) throws IOException {
        response.getWriter().write(new ObjectMapper().writeValueAsString(new ExceptionResponse().setMessage("Content-Type header is required")));
        response.addHeader("Content-Type", "application/json");
    }

    private void logResponse(HttpServletResponse response) {
        logBorder();
        logResponseStatus(response.getStatus());
        logBorder();
    }

    private void logRequest(HttpServletRequest request) {
        logBorder();
        logRequestPath(request.getMethod(), request.getRequestURI());
        logBorder();
    }

    private void logRequestJson(CachedHttpServletRequest cachedHttpServletRequest) throws IOException {
        String requestBody = new String(cachedHttpServletRequest.getInputStream().readAllBytes());
        String method = cachedHttpServletRequest.getMethod();
        String requestURI = cachedHttpServletRequest.getRequestURI();
        logBorder();
        logRequestPath(method, requestURI);
        logRequestBody(requestBody);
        logBorder();
    }

    private void logResponseJson(ContentCachingResponseWrapper contentCachingResponseWrapper) throws IOException {
        String responseBody = new String(contentCachingResponseWrapper.getContentAsByteArray());
        int status = contentCachingResponseWrapper.getStatus();
        logBorder();
        logResponseStatus(status);
        logResponseBody(responseBody);
        logBorder();
        contentCachingResponseWrapper.copyBodyToResponse();
    }


    private String formatJson(String requestBody) throws JsonProcessingException {
        if (requestBody == null || requestBody.isBlank()) return "";
        ObjectMapper mapper = new ObjectMapper();
        Object object = mapper.readValue(requestBody, Object.class);
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
    }

    private void logResponseBody(String responseBody) throws JsonProcessingException {
        log.info("<< RESPONSE BODY: \n{}", formatJson(responseBody));
    }

    private void logResponseStatus(int status) {
        log.info("<< RESPONSE STATUS: {}", status);
    }

    private void logRequestBody(String requestBody) throws JsonProcessingException {
        log.info(">> REQUEST BODY: \n{}", formatJson(requestBody));
    }

    private void logRequestPath(String method, String requestURI) {
        log.info(">> REQUEST PATH: [{}] {}", method, requestURI);
    }

    private void logBorder() {
        log.info("==============================");
    }
}