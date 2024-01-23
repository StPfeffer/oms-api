package pfeffer.oms.inventory.jakarta.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pfeffer.oms.inventory.domain.dtos.LocationDTO;
import pfeffer.oms.inventory.domain.enums.EnumStockType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stock")
public class JakartaStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sku_id", nullable = false)
    private String skuId;

    @Column(name = "location_id", nullable = false)
    private LocationDTO location;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "threshold")
    private Integer threshold;

    @Enumerated(EnumType.STRING)
    @Column(name = "stock_type", nullable = false)
    private EnumStockType stockType;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

}
