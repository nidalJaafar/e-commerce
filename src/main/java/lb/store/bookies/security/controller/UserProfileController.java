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

/**
 * User profile controller.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserProfileController {

    private final UserService service;

    /**
     * Get user response.
     *
     * @return the user response
     */
    @GetMapping("/profile")
    public UserResponse get() {
        return service.get();
    }

    /**
     * Put user response.
     *
     * @param request the request
     * @return the user response
     */
    @PutMapping("/profile")
    public UserResponse put(@Valid @RequestBody JwtRequest request) {
        return service.put(request);
    }

    /**
     * Delete.
     */
    @DeleteMapping("/profile")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete() {
        service.delete();
    }

    /**
     * Get user response.
     *
     * @param id the id
     * @return the user response
     */
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public UserResponse get(@PathVariable UUID id) {
        return service.get(id);
    }

    /**
     * Gets users.
     *
     * @return the users
     */
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public UsersResponse getUsers() {
        return service.getUsers();
    }

    /**
     * Put user response.
     *
     * @param request the request
     * @param id      the id
     * @return the user response
     */
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse put(@Valid @RequestBody JwtRequest request, @PathVariable UUID id) {
        return service.put(request, id);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
