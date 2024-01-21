package lb.store.ecommerce.security.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Component
public class KeycloakJwtRolesConverter implements Converter<Jwt, Collection<GrantedAuthority>> {
    public static final String PREFIX_RESOURCE_ROLE = "ROLE";
    private static final String CLAIM_RESOURCE_ACCESS = "resource_access";
    private static final String CLAIM_ROLES = "roles";
    @Value("${keycloak-client-id}")
    private String clientId;


    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        Map<String, Map<String, Collection<String>>> resourceAccess = jwt.getClaim(CLAIM_RESOURCE_ACCESS);
        Map<String, Collection<String>> stringCollectionMap = resourceAccess.get(clientId);
        stringCollectionMap.get(CLAIM_ROLES).forEach(role -> grantedAuthorities.add(new SimpleGrantedAuthority(PREFIX_RESOURCE_ROLE + "_" + role)));
        return grantedAuthorities;
    }
}
