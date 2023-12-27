package lb.store.ecommerce.security.service;

import lb.store.ecommerce.security.request.JwtRequest;
import lb.store.ecommerce.security.response.UserResponse;
import lb.store.ecommerce.security.response.UsersResponse;

import java.util.UUID;

/**
 * User service.
 */
public interface UserService {
    /**
     * Get user response.
     *
     * @return the user response
     */
    UserResponse get();

    /**
     * Put user response.
     *
     * @param request the request
     * @return the user response
     */
    UserResponse put(JwtRequest request);

    /**
     * Delete.
     */
    void delete();

    /**
     * Put user response.
     *
     * @param request the request
     * @param id      the id
     * @return the user response
     */
    UserResponse put(JwtRequest request, UUID id);

    /**
     * Get user response.
     *
     * @param id the id
     * @return the user response
     */
    UserResponse get(UUID id);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(UUID id);

    /**
     * Gets users.
     *
     * @return the users
     */
    UsersResponse getUsers();
}
