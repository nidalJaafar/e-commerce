package lb.store.bookies.module.highlight.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lb.store.bookies.common.dto.ProductDto;
import lb.store.bookies.common.dto.ImageDto;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

/**
 * Highlight dto.
 */
@Data
public class HighlightDto implements Serializable {
    private UUID id;
    private ProductDto product;
    @JsonProperty("image")
    private ImageDto imageDto;
}
