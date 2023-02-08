package lb.store.bookies.module.highlight.request;

import lombok.Data;

import java.util.UUID;

/**
 * Highlight request.
 */
@Data
public class HighlightRequest {
    private UUID productId;
}
