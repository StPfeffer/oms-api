package pfeffer.oms.inventory.infra.jakarta.mappers;

import pfeffer.oms.inventory.domain.entities.StockBO;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaLocation;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaStock;

import java.util.Date;

public class JakartaStockMapper {

    public static JakartaStock toEntity(StockBO bo) {
        JakartaStock entity = new JakartaStock();

        entity.setSkuId(bo.getSkuId());
        entity.setQuantity(bo.getQuantity());
        entity.setThreshold(bo.getThreshold());
        entity.setStockType(bo.getStockType());
        entity.setEnabled(bo.isEnabled());
        entity.setCreatedAt(new Date());
        entity.setUpdatedAt(bo.getUpdatedAt());

        return entity;
    }

    public static StockBO toDomain(JakartaStock entity) {
        StockBO bo = new StockBO();

        bo.setSkuId(entity.getSkuId());
        bo.setLocationId(entity.getLocation().getLocationId());
        bo.setQuantity(entity.getQuantity());
        bo.setThreshold(entity.getThreshold());
        bo.setStockType(entity.getStockType());
        bo.setEnabled(entity.isEnabled());
        bo.setCreatedAt(entity.getCreatedAt());
        bo.setUpdatedAt(entity.getUpdatedAt());

        return bo;
    }

}
