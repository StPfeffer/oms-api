package pfeffer.oms.inventory.domain.mappers;

import pfeffer.oms.inventory.domain.dtos.ChannelDTO;
import pfeffer.oms.inventory.domain.entities.ChannelBO;

public class ChannelMapper {

    public static ChannelDTO toDTO(ChannelBO bo) {
        ChannelDTO newChannelDTO = new ChannelDTO();

        newChannelDTO.setId(bo.getId());
        newChannelDTO.setName(bo.getName());

        return newChannelDTO;
    }

    public static ChannelBO toBO(ChannelDTO dto) {
        ChannelBO newChannelBO = new ChannelBO();

        newChannelBO.setId(dto.getId());
        newChannelBO.setName(dto.getName());

        return newChannelBO;
    }

}
