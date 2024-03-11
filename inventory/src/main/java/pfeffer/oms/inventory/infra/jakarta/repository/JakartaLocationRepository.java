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
import pfeffer.oms.inventory.domain.repositories.location.ILocationDataBaseRepository;
import pfeffer.oms.inventory.domain.repositories.location.ILocationRepository;
import pfeffer.oms.inventory.infra.jakarta.mappers.JakartaLocationMapper;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaLocation;

@Service
public class JakartaLocationRepository extends SimpleJpaRepository<JakartaLocation, Long> implements ILocationDataBaseRepository, ILocationRepository {

    private final EntityManager em;

    private final JakartaDocumentRepository documentRepository;

    @Autowired
    public JakartaLocationRepository(EntityManager em, JakartaDocumentRepository documentRepository) {
        super(JakartaLocation.class, em);
        this.em = em;
        this.documentRepository = documentRepository;
    }

    @Override
    public LocationBO persist(LocationBO bo) {
        LocationDTO location = this.findByLocationId(bo.getId());

        if (location != null) {
            throw LocationException.ALREADY_EXISTS;
        }

        bo.getDocuments().forEach(documentBO -> {
            if (this.documentRepository.findByDocument(documentBO) != null) {
                throw new LocationException("There is already a branch registered with the provided documents", 400);
            }
        });

        JakartaLocation entity = JakartaLocationMapper.toEntity(bo);

        em.persist(entity);
        em.flush();

        return JakartaLocationMapper.toDomain(entity);
    }

    @Override
    public LocationBO update(String locationId, LocationBO bo) {
        JakartaLocation location = findEntityByLocationId(locationId, true);

        bo.setId(locationId);

        JakartaLocation entity = JakartaLocationMapper.toEntity(bo);
        entity.setId(location.getId());

        em.merge(entity);
        em.flush();

        return JakartaLocationMapper.toDomain(entity);
    }

    @Override
    public LocationDTO findByLocationId(String locationId) {
        JakartaLocation entity = this.findEntityByLocationId(locationId);

        try {
            return LocationMapper.toDTO(JakartaLocationMapper.toDomain(entity));
        } catch (NoResultException e) {
            return null;
        }
    }

    public JakartaLocation findEntityByLocationId(String locationId) {
        return this.findEntityByLocationId(locationId, false);
    }

    public JakartaLocation findEntityByLocationId(String locationId, boolean exception) {
        TypedQuery<JakartaLocation> query = em.createQuery("SELECT e FROM JakartaLocation e WHERE e.locationId = :locationId", JakartaLocation.class)
                .setParameter("locationId", locationId);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            if (exception) {
                throw LocationException.NOT_FOUND;
            }

            return null;
        }
    }

}
