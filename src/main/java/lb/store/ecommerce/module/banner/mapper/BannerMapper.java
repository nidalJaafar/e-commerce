package lb.store.ecommerce.module.banner.mapper;

import lb.store.ecommerce.common.entity.Banner;
import lb.store.ecommerce.module.banner.dto.BannerDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * Banner mapper.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface BannerMapper {

    /**
     * Banner to banner dto.
     *
     * @param banner the banner
     * @return the banner dto
     */
    BannerDto bannerToBannerDto(Banner banner);

    /**
     * Banner list to banner dto list.
     *
     * @param bannerList the banner list
     * @return the list
     */
    List<BannerDto> bannerListToBannerDtoList(List<Banner> bannerList);

}
