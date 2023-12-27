package lb.store.ecommerce.security.response;

import lb.store.ecommerce.common.dto.UserDto;
import lombok.Data;

import java.util.List;

/**
 * Users response.
 */
@Data
public class UsersResponse {
    private List<UserDto> userDtoList;
}
