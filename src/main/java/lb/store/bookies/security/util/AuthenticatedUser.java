package lb.store.bookies.security.util;

import lb.store.bookies.security.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthenticatedUser {

    public static User getAuthenticatedUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}