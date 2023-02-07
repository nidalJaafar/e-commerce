package lb.store.bookies.module.cart.dto;

import lb.store.bookies.module.product.dto.ProductDto;
import lb.store.bookies.security.dto.UserDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CartDto implements Serializable {
    private UserDto user;
    private ProductDto product;
    private Long quantity;
}
