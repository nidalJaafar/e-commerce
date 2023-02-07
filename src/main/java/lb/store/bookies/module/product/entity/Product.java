package lb.store.bookies.module.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lb.store.bookies.common.BaseEntity;
import lb.store.bookies.module.category.entity.Category;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name", "description", "image"}))
public class Product extends BaseEntity {

    private String name;
    private String description;
    private Long quantity;
    private Double price;
    private String image;
    @ManyToMany
    @ToString.Exclude
    private List<Category> categories;
}
