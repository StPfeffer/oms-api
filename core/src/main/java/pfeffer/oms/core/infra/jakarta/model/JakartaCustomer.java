package pfeffer.oms.core.infra.jakarta.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pfeffer.oms.core.domain.enums.EnumCustomerType;

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

    @Column(name = "addresses")
    private List<JakartaAddress> addresses;

    @Column(name = "telephones")
    private List<JakartaTelephone> telephones;

    @Column(name = "documents")
    private List<JakartaDocument> documents;

}
