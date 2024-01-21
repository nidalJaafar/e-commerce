package lb.store.ecommerce.module.cart.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class CartRequest {
    private UUID productId;
    @NotNull
    private Long quantity;
}
