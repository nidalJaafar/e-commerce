package lb.store.ecommerce.module.cart.dto;

import lb.store.ecommerce.common.dto.ProductDto;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class CartDto implements Serializable {
    private UUID userId;
    private ProductDto product;
    private Long quantity;
}
