package lb.store.bookies.module.category.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lb.store.bookies.common.BaseEntity;
import lb.store.bookies.module.product.entity.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * The type Category.
 */
@Getter
@Setter
@ToString
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Category extends BaseEntity {
    private String name;
    @ManyToMany(mappedBy = "categories")
    @ToString.Exclude
    private List<Product> products;
}
