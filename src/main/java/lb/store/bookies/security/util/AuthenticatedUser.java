package lb.store.bookies.security.util;

import lb.store.bookies.security.entity.User;
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
