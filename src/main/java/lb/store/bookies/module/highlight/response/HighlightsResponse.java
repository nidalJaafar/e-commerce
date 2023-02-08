package lb.store.bookies.module.highlight.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lb.store.bookies.module.highlight.dto.HighlightDto;
import lombok.Data;

import java.util.List;

/**
 * Highlights response.
 */
@Data
public class HighlightsResponse {
    @JsonProperty("data")
    private List<HighlightDto> highlightDtoList;
}
