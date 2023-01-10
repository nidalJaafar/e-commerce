package lb.store.bookies.module.category.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lb.store.bookies.common.BaseEntity;
import lb.store.bookies.module.product.entity.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class Category extends BaseEntity {

    private String Name;
    @ManyToMany(mappedBy = "categories")
    @ToString.Exclude
    private List<Product> products;
}
