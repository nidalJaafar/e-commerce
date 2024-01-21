package lb.store.ecommerce.common.mapper;

import lb.store.ecommerce.common.dto.ImageDto;
import lb.store.ecommerce.common.entity.Image;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ImageMapper {
    ImageDto imageToImageDto(Image image);

    List<ImageDto> imageListToImageDtoList(List<Image> imageList);
}
