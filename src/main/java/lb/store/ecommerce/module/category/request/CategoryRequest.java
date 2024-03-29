package lb.store.ecommerce.module.category.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * Category request.
 */
@Data
public class CategoryRequest {
    @NotEmpty
    private String name;
}
