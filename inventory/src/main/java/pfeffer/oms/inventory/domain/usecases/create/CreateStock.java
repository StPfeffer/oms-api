package pfeffer.oms.inventory.domain.usecases.create;

import pfeffer.oms.inventory.domain.dtos.StockDTO;
import pfeffer.oms.inventory.domain.entities.StockBO;
import pfeffer.oms.inventory.domain.mappers.StockMapper;
import pfeffer.oms.inventory.domain.repositories.IStockDataBaseRepository;

public class CreateStock extends AbstractCreateUseCase<StockDTO, StockBO, StockMapper, IStockDataBaseRepository> {

    public CreateStock(IStockDataBaseRepository repository) {
        super(repository, new StockMapper());
    }

}
