package lb.store.bookies.module.category.service.impl;

import lb.store.bookies.common.repository.CategoryRepository;
import lb.store.bookies.module.category.entity.Category;
import lb.store.bookies.module.category.mapper.CategoryMapper;
import lb.store.bookies.module.category.request.CategoryPostRequest;
import lb.store.bookies.module.category.request.CategoryPutRequest;
import lb.store.bookies.module.category.response.CategoriesResponse;
import lb.store.bookies.module.category.response.CategoryResponse;
import lb.store.bookies.module.category.service.CategoryCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * The type Category crud service.
 */
@Service
@RequiredArgsConstructor
public class CategoryCrudServiceImpl implements CategoryCrudService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponse get(UUID id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        return new CategoryResponse().setCategoryDto(categoryMapper.categoryToCategoryDto(category));
    }

    @Override
    public CategoriesResponse get() {
        List<Category> categories = categoryRepository.findAll();
        return new CategoriesResponse().setCategoryDtoList(categoryMapper.categoryListToCategoryDtoList(categories));
    }

    @Override
    public CategoryResponse post(CategoryPostRequest request) {
        Category category = categoryRepository.save(categoryMapper.categoryPostRequestToCategory(request));
        return new CategoryResponse().setCategoryDto(categoryMapper.categoryToCategoryDto(category));
    }

    @Override
    public CategoryResponse put(CategoryPutRequest request, UUID id) {
        Category saved = categoryRepository.findById(id).orElseThrow();
        Category updated = categoryMapper.updateCategoryFromCategoryDto(categoryMapper.categoryPutRequestToCategoryDto(request), saved);
        return new CategoryResponse().setCategoryDto(categoryMapper.categoryToCategoryDto(categoryRepository.save(updated)));
    }

    @Override
    public void delete(UUID id) {
        categoryRepository.deleteById(id);
    }
}
