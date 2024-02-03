package pfeffer.oms.inventory.infra.jakarta.mappers;

import pfeffer.oms.inventory.domain.entities.LocationChannelBO;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaLocationChannel;

public class JakartaLocationChannelMapper {

    public static JakartaLocationChannel toEntity(LocationChannelBO bo) {
        JakartaLocationChannel entity = new JakartaLocationChannel();

        entity.setEnabled(bo.isEnabled());

        return entity;
    }

    public static LocationChannelBO toDomain(JakartaLocationChannel entity) {
        LocationChannelBO bo = new LocationChannelBO();

        bo.setLocationId(entity.getLocation().getLocationId());
        bo.setChannelId(entity.getChannel().getChannelId());
        bo.setEnabled(entity.isEnabled());

        return bo;
    }

}
