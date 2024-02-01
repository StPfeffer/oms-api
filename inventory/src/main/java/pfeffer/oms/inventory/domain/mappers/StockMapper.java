package pfeffer.oms.inventory.domain.mappers;

import pfeffer.oms.inventory.domain.dtos.StockDTO;
import pfeffer.oms.inventory.domain.entities.StockBO;

public class StockMapper {

    public static StockDTO toDTO(StockBO bo) {
        StockDTO dto = new StockDTO();

        dto.setSkuId(bo.getSkuId());
        dto.setLocationId(bo.getLocationId());
        dto.setQuantity(bo.getQuantity());
        dto.setThreshold(bo.getThreshold());
        dto.setStockType(bo.getStockType());
        dto.setEnabled(bo.isEnabled());
        dto.setCreatedAt(bo.getCreatedAt());
        dto.setUpdatedAt(bo.getUpdatedAt());

        return dto;
    }

    public static StockBO toBO(StockDTO dto) {
        StockBO bo = new StockBO();

        bo.setSkuId(dto.getSkuId());
        bo.setLocationId(dto.getLocationId());
        bo.setQuantity(dto.getQuantity());
        bo.setThreshold(dto.getThreshold());
        bo.setStockType(dto.getStockType());
        bo.setEnabled(dto.isEnabled());
        bo.setCreatedAt(dto.getCreatedAt());
        bo.setUpdatedAt(dto.getUpdatedAt());

        return bo;
    }

}
