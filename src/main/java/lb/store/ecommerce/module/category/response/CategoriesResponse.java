package lb.store.ecommerce.module.category.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lb.store.ecommerce.common.dto.CategoryDto;
import lombok.Data;

import java.util.List;

/**
 * Categories response.
 */
@Data
public class CategoriesResponse {
    @JsonProperty("data")
    private List<CategoryDto> categoryDtoList;
}
