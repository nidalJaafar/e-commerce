package lb.store.bookies.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @NoArgsConstructor
public class Product {


    public Long getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String Name ;
    private String Description ;
    private Long Quantity ;
    private Double Price ;
    private String Image ;
    //private Created at (Date)
    //private Updated at (Date

    private Category category;
}
