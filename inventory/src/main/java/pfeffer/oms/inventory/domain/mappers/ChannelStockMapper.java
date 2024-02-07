package pfeffer.oms.inventory.domain.mappers;

import pfeffer.oms.inventory.domain.dtos.ChannelStockDTO;
import pfeffer.oms.inventory.domain.entities.ChannelStockBO;

public class ChannelStockMapper  {

    public static ChannelStockDTO toDTO(ChannelStockBO bo) {
        ChannelStockDTO dto = new ChannelStockDTO();

        dto.setChannelId(bo.getChannelId());
        dto.setStockTypes(bo.getStockTypes());

        return dto;
    }

    public static ChannelStockBO toBO(ChannelStockDTO dto) {
        ChannelStockBO bo = new ChannelStockBO();

        bo.setChannelId(dto.getChannelId());
        bo.setStockTypes(dto.getStockTypes());

        return bo;
    }

}