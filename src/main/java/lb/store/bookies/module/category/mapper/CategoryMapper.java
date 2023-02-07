package lb.store.bookies.module.category.mapper;

import lb.store.bookies.module.category.dto.CategoryDto;
import lb.store.bookies.module.category.entity.Category;
import lb.store.bookies.module.category.request.CategoryRequest;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface CategoryMapper {
    CategoryDto categoryToCategoryDto(Category category);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Category updateCategoryFromCategoryDto(CategoryDto categoryDto, @MappingTarget Category category);

    List<CategoryDto> categoryListToCategoryDtoList(List<Category> categoryList);

    Category categoryRequestToCategory(CategoryRequest request);

    CategoryDto categoryRequestToCategoryDto(CategoryRequest request);
}
