package pfeffer.oms.inventory.jakarta.repository;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import pfeffer.oms.inventory.domain.entities.StockBO;
import pfeffer.oms.inventory.domain.repositories.IStockDataBaseRepository;
import pfeffer.oms.inventory.domain.repositories.IStockRepository;
import pfeffer.oms.inventory.jakarta.mappers.JakartaStockMapper;
import pfeffer.oms.inventory.jakarta.model.JakartaStock;

@Service
public class JakartaStockRepository extends SimpleJpaRepository<JakartaStock, Long> implements IStockDataBaseRepository, IStockRepository {

    private final EntityManager em;

    @Autowired
    public JakartaStockRepository(EntityManager em) {
        super(JakartaStock.class, em);
        this.em = em;

    }

    @Override
    public StockBO persist(StockBO bo) {
        JakartaStock entity = JakartaStockMapper.toEntity(bo);

        em.persist(entity);
        em.flush();

        return JakartaStockMapper.toDomain(entity);
    }

}
