package pfeffer.oms.inventory.domain.repositories.stock;

import pfeffer.oms.inventory.domain.dtos.StockDTO;

import java.util.List;

public interface IStockRepository {

    List<StockDTO> listBySkuId(String skuId);

    StockDTO findBySkuIdAndLocationId(String skuId, String locationId);

}
