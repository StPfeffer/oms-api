package pfeffer.oms.order.infra.jakarta.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaAddress;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaChannel;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaCustomer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order")
public class JakartaOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id", nullable = false)
    private String orderId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "channel_id", nullable = false)
    private JakartaChannel channel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private JakartaCustomer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "billing_address_id", nullable = false)
    private JakartaAddress billingAddress;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<JakartaPayment> payments;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<JakartaFulfillment> fulfillments;

    @Column(name = "price", precision = 10, scale = 4, nullable = false)
    private BigDecimal price = BigDecimal.ZERO;

    @Column(name = "shipping_price", precision = 10, scale = 4, nullable = false)
    private BigDecimal shippingPrice = BigDecimal.ZERO;

}
