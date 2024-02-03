package pfeffer.oms.inventory.domain.mappers;

import pfeffer.oms.inventory.domain.dtos.LocationChannelDTO;
import pfeffer.oms.inventory.domain.entities.LocationChannelBO;

public class LocationChannelMapper {

    public static LocationChannelDTO toDTO(LocationChannelBO bo) {
        LocationChannelDTO dto = new LocationChannelDTO();

        dto.setLocationId(bo.getLocationId());
        dto.setChannelId(bo.getChannelId());
        dto.setEnabled(bo.isEnabled());

        return dto;
    }

    public static LocationChannelBO toBO(LocationChannelDTO dto) {
        LocationChannelBO bo = new LocationChannelBO();

        bo.setLocationId(dto.getLocationId());
        bo.setChannelId(dto.getChannelId());
        bo.setEnabled(dto.isEnabled());

        return bo;
    }

}
