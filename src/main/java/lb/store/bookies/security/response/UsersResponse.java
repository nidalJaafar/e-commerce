package lb.store.bookies.security.response;

import lb.store.bookies.security.dto.UserDto;
import lombok.Data;

import java.util.List;

@Data
public class UsersResponse {
    private List<UserDto> userDtoList;
}
