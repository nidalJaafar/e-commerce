package lb.store.bookies.module.product.dto;

import lb.store.bookies.module.category.dto.CategoryDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
public class ProductDto implements Serializable {
    private UUID id;
    private String name;
    private String description;
    private Long quantity;
    private Double price;
    private String image;
    private List<CategoryDto> categories;
}
