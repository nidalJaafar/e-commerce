package lb.store.bookies.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * Product dto.
 */
@Data
public class ProductDto implements Serializable {
    private UUID id;
    private String name;
    private String description;
    private Long quantity;
    private Double price;
    @JsonProperty("main_image")
    private ImageDto mainImageDto;
    @JsonProperty("image_list")
    private List<ImageDto> imageDtoList;
    private List<CategoryDto> categories;
}
