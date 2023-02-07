package lb.store.bookies.module.cart.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lb.store.bookies.module.cart.dto.CartDto;
import lombok.Data;

import java.util.List;

@Data
public class CartResponse {
    @JsonProperty("data")
    private List<CartDto> cartDtoList;
}
