package lb.store.bookies.security.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lb.store.bookies.common.dto.UserDto;
import lombok.Data;

/**
 * User response.
 */
@Data
public class UserResponse {
    @JsonProperty("data")
    private UserDto userDto;
}
