package lb.store.bookies.module.order.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lb.store.bookies.common.BaseEntity;
import lb.store.bookies.module.product.entity.Product;
import lb.store.bookies.security.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    @OneToOne
    private User user;
    @ManyToOne
    private Product product;
    private Long quantity;
}
