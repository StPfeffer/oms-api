package pfeffer.oms.inventory.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfeffer.oms.inventory.domain.dtos.StockDTO;
import pfeffer.oms.inventory.domain.exceptions.StockException;
import pfeffer.oms.inventory.domain.repositories.IStockRepository;
import pfeffer.oms.inventory.domain.usecases.CreateStock;
import pfeffer.oms.inventory.domain.usecases.UpdateStock;
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
    public List<StockDTO> listStockBySkuId(String skuId) {
        List<StockDTO> stocks = this.repository.listStockBySkuId(skuId);

        if (stocks == null) {
            throw new StockException("There is no stock registered for the provided skuId", 404);
        }

        return stocks;
    }

    @Override
    public StockDTO findStockBySkuIdAndLocationId(String skuId, String locationId) {
        StockDTO stock = this.repository.findStockBySkuIdAndLocationId(skuId, locationId);

        if (stock == null) {
            throw new StockException("There is no stock registered for the provided skuId", 404);
        }

        return stock;
    }

}
