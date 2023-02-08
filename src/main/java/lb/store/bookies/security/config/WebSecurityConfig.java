package lb.store.bookies.security.config;

import lb.store.bookies.security.filter.JwtRequestFilter;
import lb.store.bookies.security.service.impl.JwtUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Web security config.
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

    /**
     * Password encoder password encoder.
     *
     * @return the password encoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * Configure security filter chain.
     *
     * @param http            the http
     * @param filter          the filter
     * @param service         the service
     * @param passwordEncoder the password encoder
     * @return the security filter chain
     * @throws Exception the exception
     */
    @Bean
    public SecurityFilterChain configure(HttpSecurity http, JwtRequestFilter filter, JwtUserDetailsService service, PasswordEncoder passwordEncoder) throws Exception {
        AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManagerBuilder.class).userDetailsService(service).passwordEncoder(passwordEncoder).and().build();
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/user/login").permitAll()
                .requestMatchers("/api/v1/user/signup").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/v1/product/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/v1/category/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/v1/highlight/**").permitAll()
                .anyRequest().authenticated()
                .and().authenticationManager(authenticationManager).sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}

