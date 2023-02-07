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

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/highlight")
public class HighlightCrudController {

    private final HighlightCrudService service;

    @GetMapping
    public HighlightsResponse get() {
        return service.get();
    }

    @GetMapping("/{id}")
    public HighlightResponse get(@PathVariable UUID id) {
        return service.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public HighlightResponse post(@Valid @RequestBody HighlightRequest request) {
        return service.post(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public HighlightResponse put(@Valid @RequestBody HighlightRequest request, @PathVariable UUID id) {
        return service.put(request, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
