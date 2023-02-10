package lb.store.bookies.module.highlight.controller;

import jakarta.validation.Valid;
import lb.store.bookies.module.highlight.request.HighlightRequest;
import lb.store.bookies.module.highlight.response.HighlightResponse;
import lb.store.bookies.module.highlight.response.HighlightsResponse;
import lb.store.bookies.module.highlight.service.HighlightCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * Highlight crud controller.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/highlight")
public class HighlightCrudController {

    private final HighlightCrudService service;

    /**
     * Get highlights response.
     *
     * @return the highlights response
     */
    @GetMapping
    public HighlightsResponse get() {
        return service.get();
    }

    /**
     * Get highlight response.
     *
     * @param id the id
     * @return the highlight response
     */
    @GetMapping("/{id}")
    public HighlightResponse get(@PathVariable UUID id) {
        return service.get(id);
    }

    /**
     * Post highlight response.
     *
     * @param request the request
     * @return the highlight response
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public HighlightResponse post(@Valid @RequestBody HighlightRequest request) {
        return service.post(request);
    }

    /**
     * Put highlight response.
     *
     * @param request the request
     * @param id      the id
     * @return the highlight response
     */
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public HighlightResponse put(@Valid @RequestBody HighlightRequest request, @PathVariable UUID id) {
        return service.put(request, id);
    }

    /**
     * Update image.
     *
     * @param request the request
     * @param id      the id
     */
    @PutMapping("/image/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public void updateImage(@RequestPart("file") MultipartFile request, @PathVariable UUID id) {
        service.updateImage(request, id);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
