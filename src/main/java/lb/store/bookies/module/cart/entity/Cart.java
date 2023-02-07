package lb.store.bookies.module.cart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lb.store.bookies.common.BaseEntity;
import lb.store.bookies.module.product.entity.Product;
import lb.store.bookies.security.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Cart.
 */
@Getter
@Setter
@ToString
@Entity
public class Cart extends BaseEntity {
    @ManyToOne
    private User user;
    @ManyToOne
    @ToString.Exclude
    private Product product;
    private Long quantity;
}
