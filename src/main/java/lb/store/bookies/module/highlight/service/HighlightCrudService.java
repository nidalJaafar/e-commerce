package lb.store.bookies.module.highlight.service;

import lb.store.bookies.module.highlight.request.HighlightRequest;
import lb.store.bookies.module.highlight.response.HighlightResponse;
import lb.store.bookies.module.highlight.response.HighlightsResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * Highlight crud service.
 */
public interface HighlightCrudService {
    /**
     * Get highlights response.
     *
     * @return the highlights response
     */
    HighlightsResponse get();

    /**
     * Get highlight response.
     *
     * @param id the id
     * @return the highlight response
     */
    HighlightResponse get(UUID id);

    /**
     * Post highlight response.
     *
     * @param request the request
     * @return the highlight response
     */
    HighlightResponse post(HighlightRequest request);

    /**
     * Put highlight response.
     *
     * @param request the request
     * @param id      the id
     * @return the highlight response
     */
    HighlightResponse put(HighlightRequest request, UUID id);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(UUID id);

    /**
     * Update image.
     *
     * @param request the request
     * @param id      the id
     */
    void updateImage(MultipartFile request, UUID id);
}
