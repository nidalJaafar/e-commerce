package lb.store.ecommerce.module.order.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lb.store.ecommerce.module.order.dto.OrderDto;
import lombok.Data;

import java.util.List;

@Data
public class OrderResponse {
    @JsonProperty("data")
    private List<OrderDto> orderDtoList;
}
