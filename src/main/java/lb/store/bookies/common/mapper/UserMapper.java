package lb.store.bookies.common.mapper;

import lb.store.bookies.common.dto.UserDto;
import lb.store.bookies.common.entity.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * User mapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    /**
     * User dto to user.
     *
     * @param userDto the user dto
     * @return the user
     */
    User userDtoToUser(UserDto userDto);

    /**
     * User to user dto.
     *
     * @param user the user
     * @return the user dto
     */
    UserDto userToUserDto(User user);

    /**
     * After user dto.
     *
     * @param userDto the user dto
     * @return the user dto
     */
    @AfterMapping
    default UserDto after(@MappingTarget UserDto userDto) {
        return userDto.setRole(userDto.getRole().replace("ROLE_", ""));
    }

    /**
     * Update user from user.
     *
     * @param user    the user
     * @param newUser the new user
     * @return the user
     */
    default User updateUserFromUser(User user, User newUser) {
        return newUser.setPassword(user.getPassword()).setEmail(user.getEmail());
    }

    /**
     * User list to user dto list.
     *
     * @param userList the user list
     * @return the list
     */
    List<UserDto> userListToUserDtoList(List<User> userList);
}
