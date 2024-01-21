package lb.store.ecommerce.common.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * Order.
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    @ManyToOne
    private Product product;
    private Long quantity;
    private UUID userId;
}
