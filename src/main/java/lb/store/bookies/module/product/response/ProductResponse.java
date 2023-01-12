package lb.store.bookies.module.product.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lb.store.bookies.module.product.dto.ProductDto;
import lombok.Data;

@Data
public class ProductResponse {
    @JsonProperty("data")
    private  ProductDto productDto;
}