package lb.store.ecommerce.module.banner.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lb.store.ecommerce.module.banner.dto.BannerDto;
import lombok.Data;

import java.util.List;

/**
 * Highlights response.
 */
@Data
public class BannersResponse {
    @JsonProperty("data")
    private List<BannerDto> bannerDtoList;
}
