package lb.store.ecommerce.module.category.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lb.store.ecommerce.common.dto.CategoryDto;
import lombok.Data;

@Data
public class CategoryResponse {
    @JsonProperty("data")
    private CategoryDto categoryDto;
}
