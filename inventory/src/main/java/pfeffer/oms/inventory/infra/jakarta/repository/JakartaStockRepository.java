package pfeffer.oms.inventory.infra.jakarta.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import pfeffer.oms.inventory.domain.dtos.StockDTO;
import pfeffer.oms.inventory.domain.entities.StockBO;
import pfeffer.oms.inventory.domain.exceptions.LocationException;
import pfeffer.oms.inventory.domain.mappers.StockMapper;
import pfeffer.oms.inventory.domain.repositories.IStockDataBaseRepository;
import pfeffer.oms.inventory.domain.repositories.IStockRepository;
import pfeffer.oms.inventory.infra.jakarta.mappers.JakartaStockMapper;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaStock;

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

    @Override
    public StockBO update(String skuId, StockBO bo) {
        StockDTO stock = findStockBySkuId(skuId);

        if (stock == null)  {
            throw new LocationException("Não existe uma filial cadastrada para o ID informado", 404);
        }

        JakartaStock entity = JakartaStockMapper.toEntity(bo);

        em.merge(entity);
        em.flush();

        return JakartaStockMapper.toDomain(entity);
    }

    @Override
    public StockDTO findStockBySkuId(String skuId) {
        TypedQuery<JakartaStock> query = em.createQuery("SELECT e FROM JakartaStock e WHERE e.skuId = :skuId", JakartaStock.class)
                .setParameter("skuId", skuId);

        try {
            return StockMapper.toDTO(JakartaStockMapper.toDomain(query.getSingleResult()));
        } catch (NoResultException e) {
            return null;
        }
    }

}
