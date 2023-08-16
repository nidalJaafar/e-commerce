package lb.store.bookies.container.interceptor;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.springframework.util.StreamUtils;

import java.io.*;

public class CachedHttpServletRequest extends HttpServletRequestWrapper {

    private final byte[] cachedPayload;

    public CachedHttpServletRequest(HttpServletRequest request) throws IOException {
        super(request);
        InputStream requestInputStream = request.getInputStream();
        this.cachedPayload = StreamUtils.copyToByteArray(requestInputStream);
    }

    @Override
    public ServletInputStream getInputStream() {
        return new CachedServletInputStream(cachedPayload);
    }

    @Override
    public BufferedReader getReader() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(cachedPayload);
        return new BufferedReader(new InputStreamReader(byteArrayInputStream));
    }
}