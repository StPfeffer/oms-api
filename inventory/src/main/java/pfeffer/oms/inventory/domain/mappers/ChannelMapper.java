package pfeffer.oms.inventory.domain.mappers;

import pfeffer.oms.inventory.domain.dtos.ChannelDTO;
import pfeffer.oms.inventory.domain.entities.ChannelBO;

public class ChannelMapper {

    public static ChannelDTO toDTO(ChannelBO bo) {
        ChannelDTO dto = new ChannelDTO();

        dto.setChannelId(bo.getChannelId());
        dto.setDefault(bo.isDefault());

        if (bo.getStockTypes() != null && bo.getStockTypes().size() > 0) {
            dto.setStockTypes(bo.getStockTypes());
        }

        return dto;
    }

    public static ChannelBO toBO(ChannelDTO dto) {
        ChannelBO bo = new ChannelBO();

        bo.setChannelId(dto.getChannelId());
        bo.setDefault(dto.isDefault());

        if (dto.getStockTypes() != null && dto.getStockTypes().size() > 0) {
            bo.setStockTypes(dto.getStockTypes());
        }

        return bo;
    }

}
