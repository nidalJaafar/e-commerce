package lb.store.ecommerce.module.banner.request;

import lombok.Data;

import java.util.UUID;

@Data
public class BannerRequest {
    private UUID productId;
}
