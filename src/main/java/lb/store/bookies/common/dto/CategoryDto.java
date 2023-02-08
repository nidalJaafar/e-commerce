package lb.store.bookies.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

/**
 * Category dto.
 */
@Data
public class CategoryDto implements Serializable {
    private UUID id;
    private String Name;
}
