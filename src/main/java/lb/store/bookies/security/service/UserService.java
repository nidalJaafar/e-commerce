package lb.store.bookies.security.service;

import lb.store.bookies.security.request.JwtRequest;
import lb.store.bookies.security.response.UserResponse;
import lb.store.bookies.security.response.UsersResponse;

import java.util.UUID;

public interface UserService {
    UserResponse get();

    UserResponse put(JwtRequest request);

    void delete();

    UserResponse put(JwtRequest request, UUID id);

    UserResponse get(UUID id);

    void delete(UUID id);

    UsersResponse getUsers();
}
