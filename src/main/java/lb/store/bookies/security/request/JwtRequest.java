package lb.store.bookies.security.request;

import lombok.Data;

/**
 * Jwt request.
 */
@Data
public class JwtRequest {
    private String email;
    private String password;
}
