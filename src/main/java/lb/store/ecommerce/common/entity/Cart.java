package lb.store.ecommerce.common.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
public class Cart extends BaseEntity {
    @ManyToOne
    @ToString.Exclude
    private Product product;
    private Long quantity;
    private UUID userId;
}
