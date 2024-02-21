package pfeffer.oms.order.domain.dtos;

import pfeffer.oms.inventory.domain.dtos.AddressDTO;
import pfeffer.oms.inventory.domain.dtos.CustomerDTO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public final class OrderDTO {

    private String orderId;

    private String channelId;

    private String locationId;

    private Date createdAt;

    private Date updatedAt;

    private CustomerDTO customer;

    private AddressDTO billingAddress;

    private List<PaymentDTO> payments;

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

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public AddressDTO getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(AddressDTO billingAddress) {
        this.billingAddress = billingAddress;
    }

    public List<PaymentDTO> getPayments() {
        return payments;
    }

    public void setPayments(List<PaymentDTO> payments) {
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
