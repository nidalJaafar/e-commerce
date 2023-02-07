package lb.store.bookies.module.category.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lb.store.bookies.common.dto.CategoryDto;
import lombok.Data;

/**
 * Category response.
 */
@Data
public class CategoryResponse {
    @JsonProperty("data")
    private CategoryDto categoryDto;
}
