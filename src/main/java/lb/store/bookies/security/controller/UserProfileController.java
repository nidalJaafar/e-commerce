package lb.store.bookies.security.controller;

import jakarta.validation.Valid;
import lb.store.bookies.security.request.JwtRequest;
import lb.store.bookies.security.response.UserResponse;
import lb.store.bookies.security.response.UsersResponse;
import lb.store.bookies.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserProfileController {

    private final UserService service;

    @GetMapping("/profile")
    public UserResponse get() {
        return service.get();
    }

    @PutMapping("/profile")
    public UserResponse put(@Valid @RequestBody JwtRequest request) {
        return service.put(request);
    }

    @DeleteMapping("/profile")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete() {
        service.delete();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public UserResponse get(@PathVariable UUID id) {
        return service.get(id);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public UsersResponse getUsers() {
        return service.getUsers();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse put(@Valid @RequestBody JwtRequest request, @PathVariable UUID id) {
        return service.put(request, id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
