package lb.store.ecommerce.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class CategoryDto implements Serializable {
    private UUID id;
    private String name;
}
