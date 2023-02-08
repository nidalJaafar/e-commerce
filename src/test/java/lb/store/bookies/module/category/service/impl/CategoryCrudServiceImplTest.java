package lb.store.bookies.module.category.service.impl;

import lb.store.bookies.common.repository.CategoryRepository;
import lb.store.bookies.common.dto.CategoryDto;
import lb.store.bookies.common.entity.Category;
import lb.store.bookies.module.category.mapper.CategoryMapper;
import lb.store.bookies.module.category.request.CategoryRequest;
import lb.store.bookies.module.category.response.CategoriesResponse;
import lb.store.bookies.module.category.response.CategoryResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
class CategoryCrudServiceImplTest {
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private CategoryMapper categoryMapper;
    @InjectMocks
    private CategoryCrudServiceImpl categoryCrudService;

    @Test
    void get() {
        // given
        given(categoryRepository.findById(any())).willReturn(Optional.of(new Category()));
        given(categoryMapper.categoryToCategoryDto(any())).willReturn(new CategoryDto());

        // when
        CategoryResponse categoryResponse = categoryCrudService.get(UUID.randomUUID());

        // then
        then(categoryRepository).should().findById(any());
        then(categoryMapper).should().categoryToCategoryDto(any());
        assertThat(categoryResponse).isNotNull();
    }

    @Test
    void testGet() {
        // given
        given(categoryRepository.findAll()).willReturn(new ArrayList<>());
        given(categoryMapper.categoryListToCategoryDtoList(any())).willReturn(new ArrayList<>());

        // when
        CategoriesResponse categoriesResponse = categoryCrudService.get();

        // then
        then(categoryRepository).should().findAll();
        then(categoryMapper).should().categoryListToCategoryDtoList(any());
        assertThat(categoriesResponse).isNotNull();
    }

    @Test
    void post() {
        // given
        given(categoryRepository.save(any())).willReturn(new Category());
        given(categoryMapper.categoryRequestToCategory(any())).willReturn(new Category());
        given(categoryMapper.categoryToCategoryDto(any())).willReturn(new CategoryDto());

        // when
        CategoryResponse post = categoryCrudService.post(new CategoryRequest());

        // then
        then(categoryRepository).should().save(any());
        then(categoryMapper).should().categoryRequestToCategory(any());
        then(categoryMapper).should().categoryToCategoryDto(any());
        assertThat(post).isNotNull();
    }

    @Test
    void put() {
        // given
        given(categoryRepository.findById(any())).willReturn(Optional.of(new Category()));
        given(categoryMapper.updateCategoryFromCategoryDto(any(), any())).willReturn(new Category());
        given(categoryMapper.categoryRequestToCategoryDto(any())).willReturn(new CategoryDto());
        given(categoryMapper.categoryToCategoryDto(any())).willReturn(new CategoryDto());
        given(categoryRepository.save(any())).willReturn(new Category());

        // when
        CategoryResponse put = categoryCrudService.put(new CategoryRequest(), UUID.randomUUID());

        // then
        then(categoryRepository).should().save(any());
        then(categoryMapper).should().categoryRequestToCategoryDto(any());
        then(categoryMapper).should().categoryToCategoryDto(any());
        assertThat(put).isNotNull();
    }

    @Test
    void delete() {
        // given
        UUID id = UUID.randomUUID();
        doNothing().when(categoryRepository).deleteById(id);

        // when
        categoryCrudService.delete(id);

        // then
        then(categoryRepository).should().deleteById(id);
    }
}