package lb.store.bookies.module.highlight.service;

import lb.store.bookies.module.highlight.request.HighlightRequest;
import lb.store.bookies.module.highlight.response.HighlightResponse;
import lb.store.bookies.module.highlight.response.HighlightsResponse;

import java.util.UUID;

public interface HighlightCrudService {
    HighlightsResponse get();

    HighlightResponse get(UUID id);

    HighlightResponse post(HighlightRequest request);

    HighlightResponse put(HighlightRequest request, UUID id);

    void delete(UUID id);
}
