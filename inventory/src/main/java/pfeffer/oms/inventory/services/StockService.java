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
    public StockDTO updateStock(String skuId, StockDTO dto) {
        UpdateStock updateStock = new UpdateStock(repository);

        return updateStock.execute(skuId, dto);
    }

    @Override
    public StockDTO findStockBySkuId(String skuId) {
        StockDTO stock = this.repository.findStockBySkuId(skuId);

        if (stock == null) {
            throw new StockException("Não existe um estoque para o SKU informado", 404);
        }

        return stock;
    }

}
