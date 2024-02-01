package pfeffer.oms.inventory.domain.repositories;

import pfeffer.oms.inventory.domain.dtos.StockDTO;

import java.util.List;

public interface IStockRepository {

    List<StockDTO> listStockBySkuId(String skuId);

    StockDTO findStockBySkuIdAndLocationId(String skuId, String locationId);

}
