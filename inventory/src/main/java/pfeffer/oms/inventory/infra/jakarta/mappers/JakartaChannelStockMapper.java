package pfeffer.oms.inventory.infra.jakarta.mappers;

import pfeffer.oms.inventory.domain.entities.ChannelStockBO;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaChannelStock;

public class JakartaChannelStockMapper {

    public static JakartaChannelStock toEntity(ChannelStockBO bo) {
        JakartaChannelStock entity = new JakartaChannelStock();

        entity.setStockTypes(bo.getStockTypes());

        return entity;
    }

    public static ChannelStockBO toDomain(JakartaChannelStock entity) {
        ChannelStockBO bo = new ChannelStockBO();

        bo.setChannelId(entity.getChannel().getChannelId());
        bo.setStockTypes(entity.getStockTypes());

        return bo;
    }

}
