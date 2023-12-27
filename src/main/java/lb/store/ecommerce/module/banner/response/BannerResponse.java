package lb.store.ecommerce.module.banner.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lb.store.ecommerce.module.banner.dto.BannerDto;
import lombok.Data;

/**
 * Banner response.
 */
@Data
public class BannerResponse {
    @JsonProperty("data")
    private BannerDto bannerDto;
}
