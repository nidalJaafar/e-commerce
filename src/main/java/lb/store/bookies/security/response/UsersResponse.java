package lb.store.bookies.security.response;

import lb.store.bookies.common.dto.UserDto;
import lombok.Data;

import java.util.List;

/**
 * Users response.
 */
@Data
public class UsersResponse {
    private List<UserDto> userDtoList;
}
