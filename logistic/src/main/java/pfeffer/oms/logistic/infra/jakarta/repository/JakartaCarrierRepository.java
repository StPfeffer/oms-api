package pfeffer.oms.logistic.infra.jakarta.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import pfeffer.oms.logistic.domain.dtos.CarrierDTO;
import pfeffer.oms.logistic.domain.entities.CarrierBO;
import pfeffer.oms.logistic.domain.exceptions.CarrierException;
import pfeffer.oms.logistic.domain.mappers.CarrierMapper;
import pfeffer.oms.logistic.domain.repositories.ICarrierDataBaseRepository;
import pfeffer.oms.logistic.domain.repositories.ICarrierRepository;
import pfeffer.oms.logistic.infra.jakarta.mappers.JakartaCarrierMapper;
import pfeffer.oms.logistic.infra.jakarta.model.JakartaCarrier;

@Service
public class JakartaCarrierRepository extends SimpleJpaRepository<JakartaCarrier, Long> implements ICarrierDataBaseRepository, ICarrierRepository {

    private final EntityManager em;

    @Autowired
    public JakartaCarrierRepository(EntityManager em) {
        super(JakartaCarrier.class, em);
        this.em = em;
    }

    @Override
    public CarrierBO persist(CarrierBO bo) {
        JakartaCarrier entity = JakartaCarrierMapper.toEntity(bo);

        this.canCreate(entity);

        em.persist(entity);
        em.flush();

        return JakartaCarrierMapper.toDomain(entity);
    }

    private void canCreate(JakartaCarrier entity) {
        CarrierDTO carrier = this.findByCarrierId(entity.getCarrierId());

        if (carrier != null) {
            throw CarrierException.ALREADY_EXISTS;
        }
    }

    @Override
    public CarrierDTO findByCarrierId(String carrierId) {
        TypedQuery<JakartaCarrier> query = em.createQuery("SELECT e FROM JakartaCarrier e WHERE e.carrierId = :carrierId", JakartaCarrier.class)
                .setParameter("carrierId", carrierId);

        try {
            return CarrierMapper.toDTO(JakartaCarrierMapper.toDomain(query.getSingleResult()));
        } catch (NoResultException e) {
            return null;
        }
    }

}
