package pfeffer.oms.order.infra.jakarta.mappers;

import pfeffer.oms.order.domain.entities.FulfillmentBO;
import pfeffer.oms.order.infra.jakarta.model.JakartaFulfillment;

public class JakartaFulfillmentMapper {

    public static JakartaFulfillment toEntity(FulfillmentBO domain) {
        JakartaFulfillment entity = new JakartaFulfillment();

        entity.setFulfillmentId(domain.getFulfillmentId());
        entity.setCreatedAt(domain.getCreatedAt());
        entity.setUpdatedAt(domain.getUpdatedAt());
        entity.setPrice(domain.getPrice());
        entity.setShippingPrice(domain.getShippingPrice());

        return entity;
    }

    public static FulfillmentBO toDomain(JakartaFulfillment entity) {
        FulfillmentBO domain = new FulfillmentBO();

        domain.setFulfillmentId(entity.getFulfillmentId());
        domain.setCreatedAt(entity.getCreatedAt());
        domain.setUpdatedAt(entity.getUpdatedAt());
        domain.setPrice(entity.getPrice());
        domain.setShippingPrice(entity.getShippingPrice());
        domain.setLocationId(entity.getLocation().getLocationId());
        domain.setOrderId(entity.getOrder().getOrderId());
        domain.setChannelId(entity.getChannel().getChannelId());
        domain.setCarrierId(entity.getCarrier().getCarrierId());

        return domain;
    }

}