package lb.store.ecommerce.module.banner.mapper;

import lb.store.ecommerce.common.entity.Banner;
import lb.store.ecommerce.module.banner.dto.BannerDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface BannerMapper {

    BannerDto bannerToBannerDto(Banner banner);

    List<BannerDto> bannerListToBannerDtoList(List<Banner> bannerList);

}
