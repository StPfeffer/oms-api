package pfeffer.oms.order.infra.jakarta.mappers;

import pfeffer.oms.inventory.infra.jakarta.mappers.JakartaAddressMapper;
import pfeffer.oms.inventory.infra.jakarta.mappers.JakartaCustomerMapper;
import pfeffer.oms.order.domain.entities.OrderBO;
import pfeffer.oms.order.infra.jakarta.model.JakartaOrder;

public class JakartaOrderMapper {

    public static JakartaOrder toEntity(OrderBO domain) {
        JakartaOrder entity = new JakartaOrder();

        entity.setOrderId(domain.getOrderId());
        entity.setCreatedAt(domain.getCreatedAt());
        entity.setUpdatedAt(domain.getUpdatedAt());

        entity.setCustomer(JakartaCustomerMapper.toEntity(domain.getCustomer()));
        entity.setBillingAddress(JakartaAddressMapper.toEntity(domain.getBillingAddress()));

        entity.setPayments(domain.getPayments().stream().map(JakartaPaymentMapper::toEntity).toList());

        entity.setPrice(domain.getPrice());
        entity.setShippingPrice(domain.getShippingPrice());

        return entity;
    }

    public static OrderBO toDomain(JakartaOrder entity) {
        OrderBO domain = new OrderBO();

        domain.setOrderId(entity.getOrderId());
        domain.setCreatedAt(entity.getCreatedAt());
        domain.setUpdatedAt(entity.getUpdatedAt());

        domain.setChannelId(entity.getChannel().getChannelId());
        domain.setLocationId(entity.getLocation().getLocationId());
        domain.setCustomer(JakartaCustomerMapper.toDomain(entity.getCustomer()));
        domain.setBillingAddress(JakartaAddressMapper.toDomain(entity.getBillingAddress()));

        domain.setPayments(entity.getPayments().stream().map(JakartaPaymentMapper::toDomain).toList());

        domain.setPrice(entity.getPrice());
        domain.setShippingPrice(entity.getShippingPrice());

        return domain;
    }

}
