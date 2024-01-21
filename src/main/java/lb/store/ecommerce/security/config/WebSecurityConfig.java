package lb.store.ecommerce.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.server.resource.authentication.DelegatingJwtGrantedAuthoritiesConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

    @Bean
    public JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter() {
        return new JwtGrantedAuthoritiesConverter();
    }

    @Bean
    public DelegatingJwtGrantedAuthoritiesConverter delegatingJwtGrantedAuthoritiesConverter(KeycloakJwtRolesConverter keycloakJwtRolesConverter, JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter) {
        return new DelegatingJwtGrantedAuthoritiesConverter(keycloakJwtRolesConverter, jwtGrantedAuthoritiesConverter);
    }


    @Bean
    public SecurityFilterChain configure(HttpSecurity http, DelegatingJwtGrantedAuthoritiesConverter authoritiesConverter) throws Exception {
        return http
                .oauth2ResourceServer(httpSecurityOAuth2ResourceServerConfigurer ->
                        httpSecurityOAuth2ResourceServerConfigurer
                                .jwt(jwtConfigurer -> jwtConfigurer
                                        .jwtAuthenticationConverter(jwt -> new JwtAuthenticationToken(jwt, authoritiesConverter.convert(jwt)))))
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry.anyRequest().permitAll())
                .build();
    }
}

