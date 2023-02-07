package lb.store.bookies.security.service.impl;

import lb.store.bookies.security.repository.UserRepository;
import lb.store.bookies.common.dto.UserDto;
import lb.store.bookies.common.entity.User;
import lb.store.bookies.security.mapper.JwtMapper;
import lb.store.bookies.common.mapper.UserMapper;
import lb.store.bookies.security.request.JwtRequest;
import lb.store.bookies.security.response.UserResponse;
import lb.store.bookies.security.response.UsersResponse;
import lb.store.bookies.security.service.UserService;
import lb.store.bookies.common.util.AuthenticatedUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * User service.
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final JwtMapper jwtMapper;
    private final UserRepository userRepository;


    @Override
    public UserResponse get() {
        return new UserResponse().setUserDto(userMapper.userToUserDto(AuthenticatedUser.getAuthenticatedUser()));
    }

    @Override
    public UserResponse put(JwtRequest request) {
        User authenticatedUser = AuthenticatedUser.getAuthenticatedUser();
        User user = jwtMapper.jwtRequestToUser(request);
        User savedUser = userRepository.save(userMapper.updateUserFromUser(user, authenticatedUser));
        return new UserResponse().setUserDto(userMapper.userToUserDto(savedUser));
    }

    @Override
    public void delete() {
        userRepository.delete(AuthenticatedUser.getAuthenticatedUser());
    }

    @Override
    public UserResponse put(JwtRequest request, UUID id) {
        User user = userRepository.findById(id).orElseThrow();
        User updatedUser = jwtMapper.jwtRequestToUser(request);
        User savedUser = userRepository.save(userMapper.updateUserFromUser(updatedUser, user));
        return new UserResponse().setUserDto(userMapper.userToUserDto(savedUser));
    }

    @Override
    public UserResponse get(UUID id) {
        User user = userRepository.findById(id).orElseThrow();
        return new UserResponse().setUserDto(userMapper.userToUserDto(user));
    }

    @Override
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public UsersResponse getUsers() {
        List<UserDto> userDtoList = userMapper.userListToUserDtoList(userRepository.findAll());
        return new UsersResponse().setUserDtoList(userDtoList);
    }
}
