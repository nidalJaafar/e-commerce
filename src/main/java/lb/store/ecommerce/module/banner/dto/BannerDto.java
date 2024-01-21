package lb.store.ecommerce.module.banner.dto;

import lb.store.ecommerce.common.dto.ImageDto;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class BannerDto implements Serializable {
    private UUID id;
    private ImageDto image;
}
