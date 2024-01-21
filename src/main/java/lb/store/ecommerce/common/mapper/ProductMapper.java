package lb.store.ecommerce.common.mapper;

import lb.store.ecommerce.common.dto.ProductDto;
import lb.store.ecommerce.common.entity.Product;
import lb.store.ecommerce.common.repository.CategoryRepository;
import lb.store.ecommerce.module.product.request.ProductRequest;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public abstract class ProductMapper {
    @Autowired
    private CategoryRepository categoryRepository;

    @Mapping(target = "mainImageDto", source = "mainImage")
    public abstract ProductDto productToProductDto(Product product);

    public abstract List<ProductDto> productListToProductDtoList(List<Product> products);

    public abstract Product productRequestToProduct(ProductRequest request);

    @AfterMapping
    public Product productCategoriesMapping(ProductRequest request, @MappingTarget Product product) {
        return product.setCategories(categoryRepository.findAllById(request.getCategoryIdList()));
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract Product updateProductFromProduct(Product newProduct, @MappingTarget Product savedProduct);
}
