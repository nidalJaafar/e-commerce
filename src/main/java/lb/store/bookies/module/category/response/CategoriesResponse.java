package lb.store.bookies.module.category.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lb.store.bookies.module.category.dto.CategoryDto;
import lombok.Data;

import java.util.List;

/**
 * The type Categories response.
 */
@Data
public class CategoriesResponse {
    @JsonProperty("data")
    private List<CategoryDto> categoryDtoList;
}
