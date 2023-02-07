package lb.store.bookies.module.highlight.dto;

import lb.store.bookies.module.product.dto.ProductDto;
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
}
