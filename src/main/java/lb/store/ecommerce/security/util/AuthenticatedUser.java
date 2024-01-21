package lb.store.ecommerce.security.util;

import lb.store.ecommerce.security.type.Role;
import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.UUID;

@Data
public class AuthenticatedUser {
    private UUID id;
    private String email;
    private Role role;
    private String firstName;
    private String lastName;

    public static AuthenticatedUser getAuthenticatedUser() {
        AuthenticatedUser authenticatedUser = new AuthenticatedUser();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Jwt jwt = (Jwt) authentication.getCredentials();
        authentication.getAuthorities().stream().findFirst().ifPresent(grantedAuthority -> authenticatedUser.setRole(Role.valueOf(grantedAuthority.getAuthority().replace("ROLE_", ""))));
        return authenticatedUser.setId(UUID.fromString(jwt.getClaim("sub")))
                .setEmail(jwt.getClaimAsString("email"))
                .setFirstName(jwt.getClaimAsString("given_name"))
                .setLastName(jwt.getClaimAsString("family_name"));
    }
}
