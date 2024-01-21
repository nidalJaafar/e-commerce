package lb.store.ecommerce.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(value = SqlTypes.VARCHAR)
    protected UUID id;
    @CreationTimestamp
    protected Timestamp createdAt;
    @UpdateTimestamp
    protected Timestamp updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BaseEntity baseEntity = (BaseEntity) o;
        return id != null && Objects.equals(id, baseEntity.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
