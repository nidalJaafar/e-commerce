package lb.store.bookies.module.category.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class CategoryDto implements Serializable {
    private final UUID id;
    private final String Name;
}
