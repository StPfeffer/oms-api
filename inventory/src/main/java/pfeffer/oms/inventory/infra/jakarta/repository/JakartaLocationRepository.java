package pfeffer.oms.inventory.infra.jakarta.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import pfeffer.oms.inventory.domain.dtos.LocationDTO;
import pfeffer.oms.inventory.domain.entities.LocationBO;
import pfeffer.oms.inventory.domain.exceptions.LocationException;
import pfeffer.oms.inventory.domain.mappers.LocationMapper;
import pfeffer.oms.inventory.domain.repositories.ILocationDataBaseRepository;
import pfeffer.oms.inventory.domain.repositories.ILocationRepository;
import pfeffer.oms.inventory.infra.jakarta.mappers.JakartaAddressMapper;
import pfeffer.oms.inventory.infra.jakarta.mappers.JakartaLocationMapper;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaLocation;

@Service
public class JakartaLocationRepository extends SimpleJpaRepository<JakartaLocation, Long> implements ILocationDataBaseRepository, ILocationRepository {

    private final EntityManager em;

    @Autowired
    public JakartaLocationRepository(EntityManager em) {
        super(JakartaLocation.class, em);
        this.em = em;
    }

    @Override
    public LocationBO persist(LocationBO bo) {
        LocationDTO location = this.findLocationByLocationId(bo.getId());

        if (location != null) {
            throw new LocationException("There is already a branch registered with the provided id.", 400);
        }

        JakartaLocation entity = JakartaLocationMapper.toEntity(bo);

        em.persist(entity);
        em.flush();

        return JakartaLocationMapper.toDomain(entity);
    }

    @Override
    public LocationBO update(String locationId, LocationBO bo) {
        LocationDTO location = findLocationByLocationId(locationId);

        if (location == null)  {
            throw new LocationException("There is no branch registered with the provided id", 404);
        }

        bo.setId(locationId);

        JakartaLocation entity = JakartaLocationMapper.toEntity(bo);

        em.merge(entity);
        em.flush();

        return JakartaLocationMapper.toDomain(entity);
    }

    @Override
    public LocationDTO findLocationByLocationId(String locationId) {
        TypedQuery<JakartaLocation> query = em.createQuery("SELECT e FROM JakartaLocation e WHERE e.locationId = :locationId", JakartaLocation.class)
                .setParameter("locationId", locationId);

        try {
            return LocationMapper.toDTO(JakartaLocationMapper.toDomain(query.getSingleResult()));
        } catch (NoResultException e) {
            return null;
        }
    }

}
