package lb.store.ecommerce.module.product.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lb.store.ecommerce.common.dto.ProductDto;
import lombok.Data;

/**
 * Product response.
 */
@Data
public class ProductResponse {
    @JsonProperty("data")
    private ProductDto productDto;
}
