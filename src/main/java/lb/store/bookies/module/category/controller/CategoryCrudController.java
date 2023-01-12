package lb.store.bookies.module.category.controller;

import lb.store.bookies.module.category.request.CategoryPostRequest;
import lb.store.bookies.module.category.request.CategoryPutRequest;
import lb.store.bookies.module.category.response.CategoriesResponse;
import lb.store.bookies.module.category.response.CategoryResponse;
import lb.store.bookies.module.category.service.CategoryCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * The type Category crud controller.
 */
@RequiredArgsConstructor
@RestController("api/v1/category")
public class CategoryCrudController {

    private final CategoryCrudService service;

    /**
     * Get category response.
     *
     * @param id the id
     * @return the category response
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryResponse get(@PathVariable UUID id) {
        return service.get(id);
    }

    /**
     * Get categories response.
     *
     * @return the categories response
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
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
    public CategoryResponse post(CategoryPostRequest request) {
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
    public CategoryResponse put(CategoryPutRequest request, @PathVariable UUID id) {
        return service.put(request, id);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
