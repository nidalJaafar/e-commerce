package lb.store.bookies.module.category.controller;

import jakarta.validation.Valid;
import lb.store.bookies.module.category.request.CategoryRequest;
import lb.store.bookies.module.category.response.CategoriesResponse;
import lb.store.bookies.module.category.response.CategoryResponse;
import lb.store.bookies.module.category.service.CategoryCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Category crud controller.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/category")
public class CategoryCrudController {

    private final CategoryCrudService service;

    /**
     * Get category response.
     *
     * @param id the id
     * @return the category response
     */
    @GetMapping("/{id}")
    public CategoryResponse get(@PathVariable UUID id) {
        return service.get(id);
    }

    /**
     * Get categories response.
     *
     * @return the categories response
     */
    @GetMapping
    public CategoriesResponse get() {
        return service.get();
    }

    /**
     * Post category response.
     *
     * @param request the request
     * @return the category response
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public CategoryResponse post(@Valid @RequestBody CategoryRequest request) {
        return service.post(request);
    }

    /**
     * Put category response.
     *
     * @param request the request
     * @param id      the id
     * @return the category response
     */
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public CategoryResponse put(@Valid @RequestBody CategoryRequest request, @PathVariable UUID id) {
        return service.put(request, id);
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
