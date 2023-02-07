package lb.store.bookies.security.service;

import lb.store.bookies.security.request.JwtRequest;
import lb.store.bookies.security.response.JwtResponse;

public interface JwtService {
    JwtResponse signup(JwtRequest request);

    JwtResponse login(JwtRequest request);
}
