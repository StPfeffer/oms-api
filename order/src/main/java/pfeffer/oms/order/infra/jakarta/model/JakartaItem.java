package pfeffer.oms.order.infra.jakarta.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "item")
public class JakartaItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sku_id", nullable = false)
    private String skuId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "width", nullable = false)
    private Integer width;

    @Column(name = "length", nullable = false)
    private Integer length;

    @Column(name = "height", nullable = false)
    private Integer height;

    @Column(name = "weight", nullable = false)
    private Integer weight;

    @Column(name = "price", precision = 10, scale = 4, nullable = false)
    private BigDecimal price;

    @Column(name = "shipping_price", precision = 10, scale = 4, nullable = false)
    private BigDecimal shippingPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fulfillment_id", nullable = false)
    private JakartaFulfillment fulfillment;

}
