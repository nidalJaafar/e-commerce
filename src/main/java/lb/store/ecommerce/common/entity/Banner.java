package lb.store.ecommerce.common.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Banner extends BaseEntity {
    @OneToOne
    private Image image;
}
