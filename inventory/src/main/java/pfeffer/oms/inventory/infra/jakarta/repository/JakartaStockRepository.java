package pfeffer.oms.inventory.infra.jakarta.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import pfeffer.oms.inventory.domain.dtos.StockDTO;
import pfeffer.oms.inventory.domain.entities.StockBO;
import pfeffer.oms.inventory.domain.exceptions.StockException;
import pfeffer.oms.inventory.domain.mappers.StockMapper;
import pfeffer.oms.inventory.domain.repositories.stock.IStockDataBaseRepository;
import pfeffer.oms.inventory.domain.repositories.stock.IStockRepository;
import pfeffer.oms.inventory.infra.jakarta.mappers.JakartaStockMapper;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaLocation;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaStock;

import java.util.List;

@Service
public class JakartaStockRepository extends SimpleJpaRepository<JakartaStock, Long> implements IStockDataBaseRepository, IStockRepository {

    private final EntityManager em;

    private final JakartaLocationRepository locationRepository;

    @Autowired
    public JakartaStockRepository(EntityManager em, JakartaLocationRepository locationRepository) {
        super(JakartaStock.class, em);
        this.em = em;
        this.locationRepository = locationRepository;
    }

    @Override
    public StockBO persist(StockBO bo) {
        JakartaLocation location = locationRepository.findEntityByLocationId(bo.getLocationId(), true);

        JakartaStock entity = JakartaStockMapper.toEntity(bo);
        entity.setLocation(location);

        this.canCreate(entity);

        em.persist(entity);
        em.flush();

        return JakartaStockMapper.toDomain(entity);
    }

    @Override
    public StockBO update(String locationId, String skuId, StockBO bo) {
        JakartaStock stock = findJakartaStockBySkuIdAndLocationId(skuId, locationId);

        JakartaStock entity = JakartaStockMapper.toEntity(bo);
        entity.setId(stock.getId());
        entity.setLocation(locationRepository.findEntityByLocationId(bo.getLocationId()));

        em.merge(entity);
        em.flush();

        return JakartaStockMapper.toDomain(entity);
    }

    @Override
    public List<StockDTO> listStockBySkuId(String skuId) {
        TypedQuery<JakartaStock> query = em.createQuery("SELECT e FROM JakartaStock e WHERE e.skuId = :skuId", JakartaStock.class)
                .setParameter("skuId", skuId);

        try {
            List<JakartaStock> stocks = query.getResultList();

            return stocks.stream().map(jakartaStock ->
                    StockMapper.toDTO(JakartaStockMapper.toDomain(jakartaStock))
            ).toList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public StockDTO findStockBySkuIdAndLocationId(String skuId, String locationId) {
        TypedQuery<JakartaStock> query = em.createQuery("SELECT e FROM JakartaStock e WHERE e.skuId = :skuId AND e.location.locationId = :locationId", JakartaStock.class)
                .setParameter("skuId", skuId)
                .setParameter("locationId", locationId);

        try {
            return StockMapper.toDTO(JakartaStockMapper.toDomain(query.getSingleResult()));
        } catch (NoResultException e) {
            return null;
        }
    }

    public JakartaStock findJakartaStockBySkuIdAndLocationId(String skuId, String locationId) {
        return this.findJakartaStockBySkuIdAndLocationId(skuId, locationId, false);
    }

    public JakartaStock findJakartaStockBySkuIdAndLocationId(String skuId, String locationId, boolean exception) {
        TypedQuery<JakartaStock> query = em.createQuery("SELECT e FROM JakartaStock e WHERE e.skuId = :skuId AND e.location.locationId = :locationId", JakartaStock.class)
                .setParameter("skuId", skuId)
                .setParameter("locationId", locationId);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            if (exception) {
                throw new StockException("There is not stock registered for the provided skuId and locationId", 404);
            }

            return null;
        }
    }

    public void canCreate(JakartaStock entity) {
        StockDTO stock = this.findStockBySkuIdAndLocationId(entity.getSkuId(), entity.getLocation().getLocationId());

        if (stock != null) {
            throw new StockException("There is already a stock registered with the provided skuId and locationId", 400);
        }
    }

}
