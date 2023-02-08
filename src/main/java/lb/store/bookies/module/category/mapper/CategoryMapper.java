package lb.store.bookies.module.category.mapper;

import lb.store.bookies.common.dto.CategoryDto;
import lb.store.bookies.common.entity.Category;
import lb.store.bookies.module.category.request.CategoryRequest;
import org.mapstruct.*;

import java.util.List;

/**
 * Category mapper.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface CategoryMapper {
    /**
     * Category to category dto.
     *
     * @param category the category
     * @return the category dto
     */
    CategoryDto categoryToCategoryDto(Category category);

    /**
     * Update category from category dto category.
     *
     * @param categoryDto the category dto
     * @param category    the category
     * @return the category
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Category updateCategoryFromCategoryDto(CategoryDto categoryDto, @MappingTarget Category category);

    /**
     * Category list to category dto list.
     *
     * @param categoryList the category list
     * @return the list
     */
    List<CategoryDto> categoryListToCategoryDtoList(List<Category> categoryList);

    /**
     * Category request to category.
     *
     * @param request the request
     * @return the category
     */
    Category categoryRequestToCategory(CategoryRequest request);

    /**
     * Category request to category dto.
     *
     * @param request the request
     * @return the category dto
     */
    CategoryDto categoryRequestToCategoryDto(CategoryRequest request);
}
