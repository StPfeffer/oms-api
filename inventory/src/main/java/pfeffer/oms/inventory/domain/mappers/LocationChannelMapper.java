package pfeffer.oms.inventory.domain.mappers;

import pfeffer.oms.inventory.domain.dtos.LocationChannelDTO;
import pfeffer.oms.inventory.domain.entities.LocationChannelBO;

public class LocationChannelMapper {

    private static LocationChannelDTO toDTO(LocationChannelBO bo) {
        LocationChannelDTO dto = new LocationChannelDTO();

        dto.setChannel(bo.getChannel());
        dto.setLocations(bo.getLocations());

        return dto;
    }

    private static LocationChannelBO toDTO(LocationChannelDTO dto) {
        LocationChannelBO bo = new LocationChannelBO();

        bo.setChannel(dto.getChannel());
        bo.setLocations(dto.getLocations());

        return bo;
    }

}
