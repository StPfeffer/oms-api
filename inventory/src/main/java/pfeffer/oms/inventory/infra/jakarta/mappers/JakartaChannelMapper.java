package pfeffer.oms.inventory.infra.jakarta.mappers;

import pfeffer.oms.inventory.domain.entities.ChannelBO;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaChannel;

public class JakartaChannelMapper {

    public static JakartaChannel toEntity(ChannelBO bo) {
        JakartaChannel entity = new JakartaChannel();

        entity.setName(bo.getChannelId());

        return entity;
    }

    public static ChannelBO toDomain(JakartaChannel entity) {
        ChannelBO bo = new ChannelBO();

        bo.setChannelId(entity.getName());

        return bo;
    }

}
