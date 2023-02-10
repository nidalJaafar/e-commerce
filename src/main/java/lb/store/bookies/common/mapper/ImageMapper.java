package lb.store.bookies.common.mapper;

import lb.store.bookies.common.dto.ImageDto;
import lb.store.bookies.common.entity.Image;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ImageMapper {
    ImageDto imageToImageDto(Image image);

    List<ImageDto> imageListToImageDtoList(List<Image> imageList);
}
