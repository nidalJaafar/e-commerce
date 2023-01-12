package lb.store.bookies.module.product.mapper;

import lb.store.bookies.module.product.dto.ProductDto;
import lb.store.bookies.module.product.entity.Product;
import lb.store.bookies.module.product.request.ProductPostRequest;
import lb.store.bookies.module.product.request.ProductPutRequest;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "cdi")
public interface ProductMapper {
    Product productDtoToProduct(ProductDto productDto);

    ProductDto productToProductDto(Product product);
    List<ProductDto> productListToProductDtoList(List<Product> products);
    Product productPostRequestToProduct(ProductPostRequest request);
    ProductDto productPutRequestToProductDto(ProductPutRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Product updateProductFromProductDto(ProductDto productDto, @MappingTarget Product product);
}
