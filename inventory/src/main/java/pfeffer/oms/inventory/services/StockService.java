package pfeffer.oms.inventory.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfeffer.oms.inventory.domain.dtos.StockDTO;
import pfeffer.oms.inventory.domain.repositories.IStockRepository;
import pfeffer.oms.inventory.domain.usecases.CreateStock;
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

}
