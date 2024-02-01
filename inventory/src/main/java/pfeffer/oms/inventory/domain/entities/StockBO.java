package pfeffer.oms.inventory.domain.entities;

import pfeffer.oms.inventory.domain.enums.EnumStockType;

import java.util.Date;

public class StockBO {

    private String skuId;

    private String locationId;

    private Integer quantity;

    private Integer threshold;

    private EnumStockType stockType;

    private boolean enabled;

    private Date createdAt;

    private Date updatedAt;

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}
