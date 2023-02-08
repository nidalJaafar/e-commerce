package lb.store.bookies.module.cart.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

/**
 * Cart request.
 */
@Data
public class CartRequest {
    private UUID productId;
    @NotNull
    private Long quantity;
}
