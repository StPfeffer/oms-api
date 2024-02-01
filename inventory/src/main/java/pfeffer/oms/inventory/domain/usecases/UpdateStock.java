package pfeffer.oms.inventory.domain.usecases;

import pfeffer.oms.inventory.domain.dtos.StockDTO;
import pfeffer.oms.inventory.domain.entities.StockBO;
import pfeffer.oms.inventory.domain.mappers.StockMapper;
import pfeffer.oms.inventory.domain.repositories.IStockDataBaseRepository;

public class UpdateStock {

    private final IStockDataBaseRepository repository;

    public UpdateStock(IStockDataBaseRepository repository) {
        this.repository = repository;
    }

    public StockDTO execute(String locationId, String skuId, StockDTO dto) {
        StockBO entity = repository.update(locationId, skuId, StockMapper.toBO(dto));

        return StockMapper.toDTO(entity);
    }

}
