package lb.store.ecommerce.security.service.impl;

import lb.store.ecommerce.common.entity.User;
import lb.store.ecommerce.security.mapper.JwtMapper;
import lb.store.ecommerce.security.repository.UserRepository;
import lb.store.ecommerce.security.request.JwtRequest;
import lb.store.ecommerce.security.response.JwtResponse;
import lb.store.ecommerce.security.service.JwtService;
import lb.store.ecommerce.security.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

/**
 * Jwt service.
 */
@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {

    private final UserRepository userRepository;
    private final JwtMapper jwtMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;

    @Override
    public JwtResponse signup(JwtRequest request) {
        User user = jwtMapper.jwtRequestToUser(request);
        userRepository.save(user);
        return new JwtResponse().setAccessToken(jwtTokenUtil.generateToken(user));
    }

    @Override
    public JwtResponse login(JwtRequest request) {
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return new JwtResponse().setAccessToken(jwtTokenUtil.generateToken(user));
        }
        throw new NoSuchElementException();
    }
}
