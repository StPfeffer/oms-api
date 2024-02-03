package pfeffer.oms.inventory.infra.jakarta.mappers;

import pfeffer.oms.inventory.domain.entities.LocationChannelBO;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaChannel;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaLocation;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaLocationChannel;

public class JakartaLocationChannelMapper {

    public static JakartaLocationChannel toEntity(LocationChannelBO bo, JakartaLocation location, JakartaChannel channel) {
        JakartaLocationChannel entity = new JakartaLocationChannel();

        entity.setLocation(location);
        entity.setChannel(channel);
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
