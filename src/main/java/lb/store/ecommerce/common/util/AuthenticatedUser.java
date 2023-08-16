package lb.store.ecommerce.common.util;

import lb.store.ecommerce.common.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Authenticated user.
 */
public class AuthenticatedUser {

    /**
     * Gets authenticated user.
     *
     * @return the authenticated user
     */
    public static User getAuthenticatedUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
