package lb.store.bookies.module.product.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
import java.util.UUID;

/**
 * Product request.
 */
@Data
public class ProductRequest {
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    @NotNull
    private Long quantity;
    @NotNull
    private Double price;
    @NotEmpty
    private List<UUID> categoryIdList;
}
