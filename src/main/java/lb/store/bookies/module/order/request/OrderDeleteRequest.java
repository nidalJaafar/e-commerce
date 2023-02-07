package lb.store.bookies.module.order.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class OrderDeleteRequest {
    @NotEmpty
    private List<UUID> orderIdList;
}
