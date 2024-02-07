package pfeffer.oms.inventory.domain.repositories.stock;

import pfeffer.oms.inventory.domain.entities.StockBO;
import pfeffer.oms.inventory.domain.repositories.IAbstractDataBaseRepository;

public interface IStockDataBaseRepository extends IAbstractDataBaseRepository<StockBO> {

    StockBO update(String locationId, String skuId, StockBO bo);

}
