package lb.store.ecommerce.module.order.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Map;
import java.util.UUID;

/**
 * Order request.
 */
@Data
public class OrderRequest {
    @NotEmpty
    private Map<UUID, Long> order;
}
