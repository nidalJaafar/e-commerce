package lb.store.bookies.module.product.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lb.store.bookies.module.product.dto.ProductDto;
import lombok.Data;

import java.util.List;

@Data
public class ProductsResponse {
    @JsonProperty("data")
    private List<ProductDto> productDtoList;
}