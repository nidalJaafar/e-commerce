package lb.store.ecommerce.module.cart.dto;

import lb.store.ecommerce.common.dto.ProductDto;
import lb.store.ecommerce.common.dto.UserDto;
import lombok.Data;

import java.io.Serializable;

/**
 * Cart dto.
 */
@Data
public class CartDto implements Serializable {
    private UserDto user;
    private ProductDto product;
    private Long quantity;
}
