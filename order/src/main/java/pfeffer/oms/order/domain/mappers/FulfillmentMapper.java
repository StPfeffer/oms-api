package pfeffer.oms.order.domain.mappers;

import pfeffer.oms.order.domain.dtos.FulfillmentDTO;
import pfeffer.oms.order.domain.entities.FulfillmentBO;

public class FulfillmentMapper {

    public static FulfillmentDTO toDTO(FulfillmentBO bo) {
        FulfillmentDTO dto = new FulfillmentDTO();

        dto.setFulfillmentId(bo.getFulfillmentId());
        dto.setOrderId(bo.getOrderId());
        dto.setLocationId(bo.getLocationId());
        dto.setCreatedAt(bo.getCreatedAt());
        dto.setUpdatedAt(bo.getUpdatedAt());

        dto.setPrice(bo.getPrice());
        dto.setShippingPrice(bo.getShippingPrice());

        return dto;
    }

    public static FulfillmentBO toBO(FulfillmentDTO dto) {
        FulfillmentBO bo = new FulfillmentBO();

        bo.setFulfillmentId(dto.getFulfillmentId());
        bo.setOrderId(dto.getOrderId());
        bo.setLocationId(dto.getLocationId());
        bo.setCreatedAt(dto.getCreatedAt());
        bo.setUpdatedAt(dto.getUpdatedAt());

        bo.setPrice(dto.getPrice());
        bo.setShippingPrice(dto.getShippingPrice());

        return bo;
    }

}
