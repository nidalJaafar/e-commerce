package lb.store.bookies.security.mapper;

import lb.store.bookies.security.dto.UserDto;
import lb.store.bookies.security.entity.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    User userDtoToUser(UserDto userDto);

    UserDto userToUserDto(User user);

    @AfterMapping
    default UserDto after(@MappingTarget UserDto userDto) {
        return userDto.setRole(userDto.getRole().replace("ROLE_", ""));
    }

    default User updateUserFromUser(User user, User newUser) {
        return newUser.setPassword(user.getPassword()).setEmail(user.getEmail());
    }

    List<UserDto> userListToUserDtoList(List<User> userList);
}
