package lb.store.bookies.security.controller;

import jakarta.validation.Valid;
import lb.store.bookies.security.request.JwtRequest;
import lb.store.bookies.security.response.JwtResponse;
import lb.store.bookies.security.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class JwtController {

    private final JwtService service;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public JwtResponse signup(@Valid @RequestBody JwtRequest request) {
        return service.signup(request);
    }

    @PostMapping("/login")
    public JwtResponse login(@Valid @RequestBody JwtRequest request) {
        return service.login(request);
    }
}
