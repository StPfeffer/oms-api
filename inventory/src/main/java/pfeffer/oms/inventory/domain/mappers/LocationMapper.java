package pfeffer.oms.inventory.domain.mappers;

import pfeffer.oms.inventory.domain.dtos.LocationDTO;
import pfeffer.oms.inventory.domain.entities.LocationBO;

public class LocationMapper {

    public static LocationDTO toDTO(LocationBO bo) {
        LocationDTO dto = new LocationDTO();

        dto.setId(bo.getId());
        dto.setTradingName(bo.getTradingName());
        dto.setAlias(bo.getAlias());
        dto.setName(bo.getName());
        dto.setDescription(bo.getDescription());
        dto.setAddress(bo.getAddress());

        return dto;
    }

    public static LocationBO toBO(LocationDTO dto) {
        LocationBO bo = new LocationBO();

        bo.setId(dto.getId());
        bo.setTradingName(dto.getTradingName());
        bo.setAlias(dto.getAlias());
        bo.setName(dto.getName());
        bo.setDescription(dto.getDescription());
        bo.setAddress(dto.getAddress());

        return bo;
    }

}
