package lb.store.bookies.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

/**
 * User dto.
 */
@Data
public class UserDto implements Serializable {
    private UUID id;
    private String email;
    private String role;
}
