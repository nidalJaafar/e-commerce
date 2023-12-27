package lb.store.ecommerce.security.service;

import lb.store.ecommerce.security.request.JwtRequest;
import lb.store.ecommerce.security.response.JwtResponse;

/**
 * Jwt service.
 */
public interface JwtService {
    /**
     * Signup jwt response.
     *
     * @param request the request
     * @return the jwt response
     */
    JwtResponse signup(JwtRequest request);

    /**
     * Login jwt response.
     *
     * @param request the request
     * @return the jwt response
     */
    JwtResponse login(JwtRequest request);
}
