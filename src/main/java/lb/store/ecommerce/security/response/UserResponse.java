package lb.store.ecommerce.security.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lb.store.ecommerce.common.dto.UserDto;
import lombok.Data;

/**
 * User response.
 */
@Data
public class UserResponse {
    @JsonProperty("data")
    private UserDto userDto;
}
