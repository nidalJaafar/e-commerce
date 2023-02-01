package lb.store.bookies.module.category.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lb.store.bookies.module.category.dto.CategoryDto;
import lombok.Data;

/**
 * The type Category response.
 */
@Data
public class CategoryResponse {
    @JsonProperty("data")
    private CategoryDto categoryDto;
}
