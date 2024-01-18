package pfeffer.oms.inventory.domain.entities;

import pfeffer.oms.inventory.domain.dtos.LocationDTO;
import pfeffer.oms.inventory.domain.enums.EnumStockType;

public class StockBO {

    /**
     * O ID do SKU no qual o estoque está vinculado.
     */
    private String skuId;

    /**
     * O ID da filial na qual o estoque pertence.
     */
    private LocationDTO location;

    /**
     * O saldo total para o respectivo SKU.
     */
    private Integer quantity;

    /**
     * A proteção de estoque para o respectivo SKU.
     */
    private Integer threshold;

    /**
     * O tipo do estoque.
     */
    private EnumStockType stockType;

    /**
     * Determina se esse saldo está disponível para o respectivo SKU.
     */
    private boolean enabled;

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public LocationDTO getLocation() {
        return location;
    }

    public void setLocation(LocationDTO location) {
        this.location = location;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    public EnumStockType getStockType() {
        return stockType;
    }

    public void setStockType(EnumStockType stockType) {
        this.stockType = stockType;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
