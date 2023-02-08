package lb.store.bookies.module.product.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;
import java.util.UUID;

/**
 * Category request.
 */
@Data
public class CategoryRequest {
    @NotEmpty
    private List<UUID> categoryIdList;
}
