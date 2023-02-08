package lb.store.bookies.module.category.service;

import lb.store.bookies.module.category.request.CategoryRequest;
import lb.store.bookies.module.category.response.CategoriesResponse;
import lb.store.bookies.module.category.response.CategoryResponse;

import java.util.UUID;

/**
 * Category crud service.
 */
public interface CategoryCrudService {
    /**
     * Get category response.
     *
     * @param id the id
     * @return the category response
     */
    CategoryResponse get(UUID id);

    /**
     * Get categories response.
     *
     * @return the categories response
     */
    CategoriesResponse get();

    /**
     * Post category response.
     *
     * @param request the request
     * @return the category response
     */
    CategoryResponse post(CategoryRequest request);

    /**
     * Put category response.
     *
     * @param request the request
     * @param id      the id
     * @return the category response
     */
    CategoryResponse put(CategoryRequest request, UUID id);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(UUID id);
}
