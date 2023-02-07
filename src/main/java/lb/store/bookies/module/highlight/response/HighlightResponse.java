package lb.store.bookies.module.highlight.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lb.store.bookies.module.highlight.dto.HighlightDto;
import lombok.Data;

@Data
public class HighlightResponse {
    @JsonProperty("data")
    private HighlightDto highlightDto;
}
