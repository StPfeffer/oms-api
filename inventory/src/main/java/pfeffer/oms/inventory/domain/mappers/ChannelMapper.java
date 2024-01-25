package pfeffer.oms.inventory.domain.mappers;

import pfeffer.oms.inventory.domain.dtos.ChannelDTO;
import pfeffer.oms.inventory.domain.entities.ChannelBO;
import pfeffer.oms.inventory.domain.interfaces.IAbstractMapper;

public class ChannelMapper implements IAbstractMapper<ChannelDTO, ChannelBO> {

    @Override
    public ChannelDTO toDTO(ChannelBO bo) {
        ChannelDTO dto = new ChannelDTO();

        dto.setChannelId(bo.getChannelId());

        return dto;
    }

    @Override
    public ChannelBO toBO(ChannelDTO dto) {
        ChannelBO bo = new ChannelBO();

        bo.setChannelId(dto.getChannelId());

        return bo;
    }

}
