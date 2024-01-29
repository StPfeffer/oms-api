package pfeffer.oms.inventory.infra.jakarta.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "telephone")
public class JakartaTelephone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ddi", nullable = false)
    private String ddi;

    @Column(name = "ddd", nullable = false)
    private String ddd;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "type", nullable = false)
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private JakartaCustomer customer;

}
