package pfeffer.oms.inventory.domain.mappers;

import pfeffer.oms.core.domain.mappers.AddressMapper;
import pfeffer.oms.inventory.domain.dtos.LocationDTO;
import pfeffer.oms.inventory.domain.entities.LocationBO;
import pfeffer.oms.inventory.domain.interfaces.IAbstractMapper;

public class LocationMapper implements IAbstractMapper<LocationDTO, LocationBO> {

    @Override
    public LocationDTO toDTO(LocationBO bo) {
        LocationDTO dto = new LocationDTO();

        dto.setId(bo.getId());
        dto.setTradingName(bo.getTradingName());
        dto.setAlias(bo.getAlias());
        dto.setName(bo.getName());
        dto.setDescription(bo.getDescription());
        dto.setAddress(AddressMapper.toDTO(bo.getAddress()));
        dto.setCreatedAt(bo.getCreatedAt());
        dto.setUpdatedAt(bo.getUpdatedAt());

        return dto;
    }

    @Override
    public LocationBO toBO(LocationDTO dto) {
        LocationBO bo = new LocationBO();

        bo.setId(dto.getId());
        bo.setTradingName(dto.getTradingName());
        bo.setAlias(dto.getAlias());
        bo.setName(dto.getName());
        bo.setDescription(dto.getDescription());
        bo.setAddress(AddressMapper.toBO(dto.getAddress()));
        bo.setCreatedAt(dto.getCreatedAt());
        bo.setUpdatedAt(dto.getUpdatedAt());

        return bo;
    }

}
