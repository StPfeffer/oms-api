package pfeffer.oms.inventory.infra.jakarta.mappers;

import pfeffer.oms.core.infra.jakarta.mappers.JakartaAddressMapper;
import pfeffer.oms.inventory.domain.entities.LocationBO;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaLocation;

public class JakartaLocationMapper {

    public static JakartaLocation toEntity(LocationBO bo) {
        JakartaLocation entity = new JakartaLocation();

        entity.setLocationId(bo.getId());
        entity.setTradingName(bo.getTradingName());
        entity.setAlias(bo.getAlias());
        entity.setName(bo.getName());
        entity.setDescription(bo.getDescription());
        entity.setAddress(JakartaAddressMapper.toEntity(bo.getAddress()));
        entity.setCreatedAt(bo.getCreatedAt());
        entity.setUpdatedAt(bo.getUpdatedAt());

        return entity;
    }

    public static LocationBO toDomain(JakartaLocation entity) {
        LocationBO bo = new LocationBO();

        bo.setId(entity.getLocationId());
        bo.setTradingName(entity.getTradingName());
        bo.setAlias(entity.getAlias());
        bo.setName(entity.getName());
        bo.setDescription(entity.getDescription());
        bo.setAddress(JakartaAddressMapper.toDomain(entity.getAddress()));
        bo.setCreatedAt(entity.getCreatedAt());
        bo.setUpdatedAt(entity.getUpdatedAt());

        return bo;
    }

}
