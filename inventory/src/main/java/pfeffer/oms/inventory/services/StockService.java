package pfeffer.oms.inventory.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfeffer.oms.inventory.domain.dtos.StockDTO;
import pfeffer.oms.inventory.domain.exceptions.StockException;
import pfeffer.oms.inventory.domain.repositories.stock.IStockRepository;
import pfeffer.oms.inventory.domain.usecases.stock.CreateStock;
import pfeffer.oms.inventory.domain.usecases.stock.UpdateStock;
import pfeffer.oms.inventory.infra.jakarta.repository.JakartaStockRepository;

import java.util.List;

@Service
public class StockService implements IStockRepository {

    private final JakartaStockRepository repository;

    @Autowired
    public StockService(JakartaStockRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public StockDTO createStock(StockDTO dto) {
        CreateStock createStock = new CreateStock(repository);

        return createStock.execute(dto);
    }

    @Transactional
    public StockDTO updateStock(String locationId, String skuId, StockDTO dto) {
        UpdateStock updateStock = new UpdateStock(repository);

        return updateStock.execute(locationId, skuId, dto);
    }

    @Override
    public List<StockDTO> listBySkuId(String skuId) {
        List<StockDTO> stocks = this.repository.listBySkuId(skuId);

        if (stocks == null) {
            throw StockException.NOT_FOUND;
        }

        return stocks;
    }

    @Override
    public StockDTO findBySkuIdAndLocationId(String skuId, String locationId) {
        StockDTO stock = this.repository.findBySkuIdAndLocationId(skuId, locationId);

        if (stock == null) {
            throw StockException.NOT_FOUND_LOCATION;
        }

        return stock;
    }

}
