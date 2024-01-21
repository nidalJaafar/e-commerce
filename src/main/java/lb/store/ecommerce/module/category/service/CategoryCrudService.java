package lb.store.ecommerce.module.category.service;

import lb.store.ecommerce.module.category.request.CategoryRequest;
import lb.store.ecommerce.module.category.response.CategoriesResponse;
import lb.store.ecommerce.module.category.response.CategoryResponse;

import java.util.UUID;

public interface CategoryCrudService {
    CategoryResponse get(UUID id);

    CategoriesResponse get();

    CategoryResponse post(CategoryRequest request);

    CategoryResponse put(CategoryRequest request, UUID id);

    void delete(UUID id);
}
