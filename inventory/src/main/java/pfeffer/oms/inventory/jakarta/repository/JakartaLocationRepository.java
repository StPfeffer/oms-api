package pfeffer.oms.inventory.jakarta.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import pfeffer.oms.inventory.domain.dtos.LocationDTO;
import pfeffer.oms.inventory.domain.entities.LocationBO;
import pfeffer.oms.inventory.domain.mappers.LocationMapper;
import pfeffer.oms.inventory.domain.repositories.ILocationDataBaseRepository;
import pfeffer.oms.inventory.domain.repositories.ILocationRepository;
import pfeffer.oms.inventory.jakarta.mappers.JakartaLocationMapper;
import pfeffer.oms.inventory.jakarta.model.JakartaLocation;

@Service
public class JakartaLocationRepository extends SimpleJpaRepository<JakartaLocation, Long> implements ILocationDataBaseRepository, ILocationRepository {

    private final EntityManager em;

    public JakartaLocationRepository(EntityManager em) {
        super(JakartaLocation.class, em);
        this.em = em;
    }

    @Override
    public LocationBO persist(LocationBO bo) {
        JakartaLocation entity = JakartaLocationMapper.toEntity(bo);

        this.canCreate(entity);

        em.persist(entity);
        em.flush();

        return JakartaLocationMapper.toDomain(entity);
    }

    public void canCreate(JakartaLocation entity) {
        LocationDTO location = this.findLocationByLocationId(entity.getLocationId());

        if (location != null) {
            throw new RuntimeException("Já existe uma filial cadastrada com esse ID");
        }
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
