package pfeffer.oms.order.domain.entities;

import pfeffer.oms.inventory.domain.entities.AddressBO;
import pfeffer.oms.inventory.domain.entities.CustomerBO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderBO {

    private String orderId;

    private String channelId;

    private String locationId;

    private Date createdAt;

    private Date updatedAt;

    private CustomerBO customer;

    private AddressBO billingAddress;

    private List<PaymentBO> payments;

    private BigDecimal price;

    private BigDecimal shippingPrice;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
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

    public CustomerBO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerBO customer) {
        this.customer = customer;
    }

    public AddressBO getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(AddressBO billingAddress) {
        this.billingAddress = billingAddress;
    }

    public List<PaymentBO> getPayments() {
        return payments;
    }

    public void setPayments(List<PaymentBO> payments) {
        this.payments = payments;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(BigDecimal shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

}
