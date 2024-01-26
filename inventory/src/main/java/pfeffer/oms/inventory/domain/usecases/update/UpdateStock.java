package pfeffer.oms.inventory.domain.usecases.update;

import pfeffer.oms.inventory.domain.dtos.StockDTO;
import pfeffer.oms.inventory.domain.entities.StockBO;
import pfeffer.oms.inventory.domain.mappers.StockMapper;
import pfeffer.oms.inventory.domain.repositories.IStockDataBaseRepository;

public class UpdateStock extends AbstractUpdateUseCase<StockDTO, StockBO, StockMapper, IStockDataBaseRepository> {

    public UpdateStock(IStockDataBaseRepository repository) {
        super(repository, new StockMapper());
    }

}

