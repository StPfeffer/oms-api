package pfeffer.oms.inventory.domain.usecases;

import pfeffer.oms.inventory.domain.dtos.StockDTO;
import pfeffer.oms.inventory.domain.entities.StockBO;
import pfeffer.oms.inventory.domain.mappers.StockMapper;
import pfeffer.oms.inventory.domain.repositories.IStockDataBaseRepository;

public class CreateStock {

    private final IStockDataBaseRepository repository;

    public CreateStock(IStockDataBaseRepository repository) {
        this.repository = repository;
    }

    public StockDTO execute(StockDTO dto) {
        StockBO entity = repository.persist(StockMapper.toBO(dto));

        return StockMapper.toDTO(entity);
    }

}
