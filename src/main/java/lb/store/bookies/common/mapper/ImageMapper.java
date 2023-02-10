package lb.store.bookies.common.mapper;

import lb.store.bookies.common.dto.ImageDto;
import lb.store.bookies.common.entity.Image;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 *Image mapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ImageMapper {
    /**
     * Image to image dto.
     *
     * @param image the image
     * @return the image dto
     */
    ImageDto imageToImageDto(Image image);

    /**
     * Image list to image dto list.
     *
     * @param imageList the image list
     * @return the list
     */
    List<ImageDto> imageListToImageDtoList(List<Image> imageList);
}
