package pfeffer.oms.inventory.infra.jakarta.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import pfeffer.oms.inventory.domain.dtos.LocationDTO;
import pfeffer.oms.inventory.domain.dtos.StockDTO;
import pfeffer.oms.inventory.domain.entities.StockBO;
import pfeffer.oms.inventory.domain.exceptions.ChannelException;
import pfeffer.oms.inventory.domain.exceptions.LocationException;
import pfeffer.oms.inventory.domain.exceptions.StockException;
import pfeffer.oms.inventory.domain.mappers.LocationMapper;
import pfeffer.oms.inventory.domain.mappers.StockMapper;
import pfeffer.oms.inventory.domain.repositories.IStockDataBaseRepository;
import pfeffer.oms.inventory.domain.repositories.IStockRepository;
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
        JakartaLocation location = locationRepository.findJakartaLocationByLocationId(bo.getLocationId());

        if (location == null) {
            throw new StockException("There is no branch registered with the provided id", 400);
        }

        JakartaStock entity = JakartaStockMapper.toEntity(bo, location);

        this.canCreate(entity);

        em.persist(entity);
        em.flush();

        return JakartaStockMapper.toDomain(entity);
    }

    @Override
    public StockBO update(String locationId, String skuId, StockBO bo) {
        StockDTO stock = findStockBySkuIdAndLocationId(skuId, locationId);

        if (stock == null)  {
            throw new LocationException("There is no branch registered with the provided id", 404);
        }

        JakartaStock entity = JakartaStockMapper.toEntity(bo, locationRepository.findJakartaLocationByLocationId(bo.getLocationId()));

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

    public void canCreate(JakartaStock entity) {
        StockDTO stock = this.findStockBySkuIdAndLocationId(entity.getSkuId(), entity.getLocation().getLocationId());

        if (stock != null) {
            throw new ChannelException("There is already a stock registered with the provided skuId and locationId", 400);
        }
    }

}
