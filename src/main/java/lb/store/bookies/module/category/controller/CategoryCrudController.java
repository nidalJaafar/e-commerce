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

@RequiredArgsConstructor
@RestController("api/v1/category")
public class CategoryCrudController {

    private final CategoryCrudService service;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryResponse get(@PathVariable UUID id) {
        return service.get(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CategoriesResponse get() {
        return service.get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse post(CategoryPostRequest request) {
        return service.post(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse put(CategoryPutRequest request, @PathVariable UUID id) {
        return service.put(request, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
