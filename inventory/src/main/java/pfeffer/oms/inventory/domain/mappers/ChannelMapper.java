package pfeffer.oms.inventory.domain.mappers;

import pfeffer.oms.inventory.domain.dtos.ChannelDTO;
import pfeffer.oms.inventory.domain.entities.ChannelBO;

public class ChannelMapper {

    public static ChannelDTO toDTO(ChannelBO bo) {
        ChannelDTO dto = new ChannelDTO();

        dto.setChannelId(bo.getChannelId());
        dto.setDefault(bo.isDefault());
        dto.setStockTypes(bo.getStockTypes().stream().map(ChannelStockMapper::toDTO).toList());

        return dto;
    }

    public static ChannelBO toBO(ChannelDTO dto) {
        ChannelBO bo = new ChannelBO();

        bo.setChannelId(dto.getChannelId());
        bo.setDefault(dto.isDefault());
        bo.setStockTypes(dto.getStockTypes().stream().map(ChannelStockMapper::toBO).toList());

        return bo;
    }

}
