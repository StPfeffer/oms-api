package pfeffer.oms.order.domain.mappers;

import pfeffer.oms.order.domain.dtos.FulfillmentDTO;
import pfeffer.oms.order.domain.entities.FulfillmentBO;

public class FulfillmentMapper {

    public static FulfillmentDTO toDTO(FulfillmentBO bo) {
        FulfillmentDTO dto = new FulfillmentDTO();

        dto.setFulfillmentId(bo.getFulfillmentId());
        dto.setOrderId(bo.getOrderId());
        dto.setChannelId(bo.getChannelId());
        dto.setLocationId(bo.getLocationId());
        dto.setCreatedAt(bo.getCreatedAt());
        dto.setUpdatedAt(bo.getUpdatedAt());
        dto.setCarrierId(bo.getCarrierId());

        dto.setItems(bo.getItems().stream().map(ItemMapper::toDTO).toList());

        dto.setPrice(bo.getPrice());
        dto.setShippingPrice(bo.getShippingPrice());

        return dto;
    }

    public static FulfillmentBO toBO(FulfillmentDTO dto) {
        FulfillmentBO bo = new FulfillmentBO();

        bo.setFulfillmentId(dto.getFulfillmentId());
        bo.setOrderId(dto.getOrderId());
        bo.setChannelId(dto.getChannelId());
        bo.setLocationId(dto.getLocationId());
        bo.setCreatedAt(dto.getCreatedAt());
        bo.setUpdatedAt(dto.getUpdatedAt());
        bo.setChannelId(dto.getCarrierId());

        bo.setItems(dto.getItems().stream().map(ItemMapper::toBO).toList());

        bo.setPrice(dto.getPrice());
        bo.setShippingPrice(dto.getShippingPrice());

        return bo;
    }

}
