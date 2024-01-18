package pfeffer.oms.inventory.domain.mappers;

import pfeffer.oms.inventory.domain.dtos.ChannelDTO;
import pfeffer.oms.inventory.domain.entities.ChannelBO;

public class ChannelMapper {

    public static ChannelDTO toDTO(ChannelBO bo) {
        ChannelDTO dto = new ChannelDTO();

        dto.setName(bo.getName());

        return dto;
    }

    public static ChannelBO toBO(ChannelDTO dto) {
        ChannelBO bo = new ChannelBO();

        bo.setName(dto.getName());

        return bo;
    }

}
