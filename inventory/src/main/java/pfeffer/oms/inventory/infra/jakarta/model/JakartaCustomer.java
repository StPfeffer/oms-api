package pfeffer.oms.inventory.infra.jakarta.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pfeffer.oms.inventory.domain.enums.EnumCustomerType;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class JakartaCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customerId", nullable = false)
    private String customerId;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "birthdate")
    private String birthdate;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private EnumCustomerType type;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<JakartaAddress> addresses;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<JakartaTelephone> telephones;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<JakartaDocument> documents;

}
