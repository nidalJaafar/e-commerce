package lb.store.bookies.module.category.service;

import lb.store.bookies.module.category.request.CategoryPostRequest;
import lb.store.bookies.module.category.request.CategoryPutRequest;
import lb.store.bookies.module.category.response.CategoriesResponse;
import lb.store.bookies.module.category.response.CategoryResponse;

import java.util.UUID;

public interface CategoryCrudService {
    CategoryResponse get(UUID id);

    CategoriesResponse get();

    CategoryResponse post(CategoryPostRequest request);

    CategoryResponse put(CategoryPutRequest request, UUID id);

    void delete(UUID id);
}
