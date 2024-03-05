package pfeffer.oms.order.domain.mappers;

import pfeffer.oms.order.domain.dtos.ItemDTO;
import pfeffer.oms.order.domain.entities.ItemBO;

public class ItemMapper {

    public static ItemDTO toDTO(ItemBO bo) {
        ItemDTO dto = new ItemDTO();

        dto.setSkuId(bo.getSkuId());
        dto.setQuantity(bo.getQuantity());
        dto.setHeight(bo.getHeight());
        dto.setLength(bo.getLength());
        dto.setWidth(bo.getWidth());
        dto.setWeight(bo.getWeight());
        dto.setPrice(bo.getPrice());
        dto.setShippingPrice(bo.getShippingPrice());

        return dto;
    }

    public static ItemBO toBO(ItemDTO dto) {
        ItemBO bo = new ItemBO();

        bo.setSkuId(dto.getSkuId());
        bo.setQuantity(dto.getQuantity());
        bo.setHeight(dto.getHeight());
        bo.setLength(dto.getLength());
        bo.setWidth(dto.getWidth());
        bo.setWeight(dto.getWeight());
        bo.setPrice(dto.getPrice());
        bo.setShippingPrice(dto.getShippingPrice());

        return bo;
    }

}
