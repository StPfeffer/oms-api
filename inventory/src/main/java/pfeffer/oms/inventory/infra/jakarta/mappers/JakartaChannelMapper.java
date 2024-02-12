package pfeffer.oms.inventory.infra.jakarta.mappers;

import pfeffer.oms.inventory.domain.entities.ChannelBO;
import pfeffer.oms.inventory.domain.entities.ChannelStockBO;
import pfeffer.oms.inventory.domain.enums.EnumStockType;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaChannel;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaChannelStock;

import java.util.Collections;
import java.util.List;

public class JakartaChannelMapper {

    public static JakartaChannel toEntity(ChannelBO bo) {
        JakartaChannel entity = new JakartaChannel();

        entity.setChannelId(bo.getChannelId());
        entity.setDefault(bo.isDefault());

        if (bo.getStockTypes() == null || bo.getStockTypes().isEmpty()) {
            ChannelStockBO channelStockBO = new ChannelStockBO();
            channelStockBO.setChannelId(bo.getChannelId());

            List<JakartaChannelStock> physicalStockType = Collections.singletonList(JakartaChannelStockMapper.toEntity(channelStockBO));

            entity.setStockTypes(physicalStockType);
        } else {
            ChannelStockBO channelStockBO = new ChannelStockBO();
            channelStockBO.setChannelId(bo.getChannelId());
            channelStockBO.setStockTypes(bo.getStockTypes());

            List<JakartaChannelStock> jakartaChannelStocks = Collections.singletonList(JakartaChannelStockMapper.toEntity(channelStockBO));

            entity.setStockTypes(jakartaChannelStocks);
        }

        return entity;
    }

    public static ChannelBO toDomain(JakartaChannel entity) {
        ChannelBO bo = new ChannelBO();

        bo.setChannelId(entity.getChannelId());
        bo.setDefault(entity.isDefault());

        if (entity.getStockTypes() == null || entity.getStockTypes().isEmpty()) {
            JakartaChannelStock jakartaChannelStock = new JakartaChannelStock();
            jakartaChannelStock.setChannel(entity);

            List<ChannelStockBO> physicalStockType = Collections.singletonList(JakartaChannelStockMapper.toDomain(jakartaChannelStock));

            bo.setStockTypes(physicalStockType.get(0).getStockTypes());
        } else {
            List<EnumStockType> stockTypes = entity.getStockTypes().stream().map(JakartaChannelStock::getStockTypes).toList().get(0);
            bo.setStockTypes(stockTypes);
        }

        return bo;
    }

}
