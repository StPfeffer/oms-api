package pfeffer.oms.inventory.infra.jakarta.mappers;

import pfeffer.oms.inventory.domain.entities.ChannelBO;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaChannel;

public class JakartaChannelMapper {

    public static JakartaChannel toEntity(ChannelBO bo) {
        JakartaChannel entity = new JakartaChannel();

        entity.setChannelId(bo.getChannelId());
        entity.setDefault(bo.isDefault());

        return entity;
    }

    public static ChannelBO toDomain(JakartaChannel entity) {
        ChannelBO bo = new ChannelBO();

        bo.setChannelId(entity.getChannelId());
        bo.setDefault(entity.isDefault());

        return bo;
    }

}
