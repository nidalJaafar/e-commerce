package lb.store.bookies.module.category.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * The type Category post request.
 */
@Data
public class CategoryRequest {
    @NotEmpty
    private String name;
}
