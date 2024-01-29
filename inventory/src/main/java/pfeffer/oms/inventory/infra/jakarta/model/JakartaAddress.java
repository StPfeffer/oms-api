package pfeffer.oms.inventory.infra.jakarta.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pfeffer.oms.inventory.domain.enums.EnumState;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class JakartaAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "zip", nullable = false)
    private String zip;

    @Column(name = "number")
    private String number;

    @Column(name = "address")
    private String address;

    @Column(name = "address2")
    private String address2;

    @Column(name = "neighbourhood")
    private String neighbourhood;

    @Column(name = "city")
    private String city;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private EnumState state;

    @Column(name = "country")
    private String country;

    @Column(name = "latitude")
    private BigDecimal latitude;

    @Column(name = "longitude")
    private BigDecimal longitude;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private JakartaCustomer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private JakartaLocation location;

}
