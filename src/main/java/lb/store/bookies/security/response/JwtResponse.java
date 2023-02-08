package lb.store.bookies.security.response;

import lombok.Data;

/**
 * Jwt response.
 */
@Data
public class JwtResponse {
    private String accessToken;
}
