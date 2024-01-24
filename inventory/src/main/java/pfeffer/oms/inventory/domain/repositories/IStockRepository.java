package pfeffer.oms.inventory.domain.repositories;

import pfeffer.oms.inventory.domain.dtos.StockDTO;

public interface IStockRepository {

    StockDTO findStockBySkuId(String skuId);

}
