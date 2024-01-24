package pfeffer.oms.inventory.domain.repositories;

import pfeffer.oms.inventory.domain.entities.StockBO;

public interface IStockDataBaseRepository extends IAbstractDataBaseRepository<StockBO> {

    StockBO update(String skuId, StockBO bo);

}
