package lb.store.bookies.module.product.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ImageRequest {
    @NotEmpty
    private List<UUID> imageIdList;
}
