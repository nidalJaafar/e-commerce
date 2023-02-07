package lb.store.bookies.security.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lb.store.bookies.security.dto.UserDto;
import lombok.Data;

@Data
public class UserResponse {
    @JsonProperty("data")
    private UserDto userDto;
}
