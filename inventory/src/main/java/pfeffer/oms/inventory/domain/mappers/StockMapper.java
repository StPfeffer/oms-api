package pfeffer.oms.inventory.domain.mappers;

import pfeffer.oms.inventory.domain.dtos.StockDTO;
import pfeffer.oms.inventory.domain.entities.StockBO;
import pfeffer.oms.inventory.domain.interfaces.IAbstractMapper;

public class StockMapper implements IAbstractMapper<StockDTO, StockBO> {

    @Override
    public StockDTO toDTO(StockBO bo) {
        StockDTO dto = new StockDTO();

        dto.setSkuId(bo.getSkuId());
        dto.setLocation(bo.getLocation());
        dto.setQuantity(bo.getQuantity());
        dto.setThreshold(bo.getThreshold());
        dto.setStockType(bo.getStockType());
        dto.setEnabled(bo.isEnabled());
        dto.setUpdatedAt(bo.getUpdatedAt());

        return dto;
    }

    @Override
    public StockBO toBO(StockDTO dto) {
        StockBO bo = new StockBO();

        bo.setSkuId(dto.getSkuId());
        bo.setLocation(dto.getLocation());
        bo.setQuantity(dto.getQuantity());
        bo.setThreshold(dto.getThreshold());
        bo.setStockType(dto.getStockType());
        bo.setEnabled(dto.isEnabled());
        bo.setUpdatedAt(dto.getUpdatedAt());

        return bo;
    }

}
