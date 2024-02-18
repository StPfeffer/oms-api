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

        return entity;
    }

    public static OrderBO toDomain(JakartaOrder order) {
        OrderBO domain = new OrderBO();

        domain.setOrderId(order.getOrderId());
        domain.setCreatedAt(order.getCreatedAt());
        domain.setUpdatedAt(order.getUpdatedAt());

        domain.setChannelId(order.getChannel().getChannelId());
        domain.setLocationId(order.getLocation().getLocationId());
        domain.setCustomer(JakartaCustomerMapper.toDomain(order.getCustomer()));
        domain.setBillingAddress(JakartaAddressMapper.toDomain(order.getBillingAddress()));

        return domain;
    }

}
