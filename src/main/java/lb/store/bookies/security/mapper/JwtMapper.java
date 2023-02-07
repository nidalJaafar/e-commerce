package lb.store.bookies.security.mapper;

import lb.store.bookies.common.entity.User;
import lb.store.bookies.security.request.JwtRequest;
import lb.store.bookies.security.type.Role;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Jwt mapper.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public abstract class JwtMapper {
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Jwt request to user.
     *
     * @param jwtRequest the jwt request
     * @return the user
     */
    public abstract User jwtRequestToUser(JwtRequest jwtRequest);

    /**
     * After mapping user.
     *
     * @param user the user
     * @return the user
     */
    @AfterMapping
    protected User afterMapping(@MappingTarget User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return user.setRole("ROLE_" + Role.USER);
    }
}
