package lb.store.ecommerce.module.product.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lb.store.ecommerce.common.dto.ProductDto;
import lombok.Data;

import java.util.List;

/**
 * Products response.
 */
@Data
public class ProductsResponse {
    @JsonProperty("data")
    private List<ProductDto> productDtoList;
}
