package lb.store.ecommerce.module.cart.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lb.store.ecommerce.module.cart.dto.CartDto;
import lombok.Data;

import java.util.List;

/**
 * Cart response.
 */
@Data
public class CartResponse {
    @JsonProperty("data")
    private List<CartDto> cartDtoList;
}
