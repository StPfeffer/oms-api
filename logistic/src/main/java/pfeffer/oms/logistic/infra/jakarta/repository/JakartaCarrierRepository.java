package pfeffer.oms.logistic.infra.jakarta.repository;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import pfeffer.oms.logistic.domain.entities.CarrierBO;
import pfeffer.oms.logistic.domain.repositories.ICarrierDataBaseRepository;
import pfeffer.oms.logistic.infra.jakarta.model.JakartaCarrier;

@Service
public class JakartaCarrierRepository extends SimpleJpaRepository<JakartaCarrier, Long> implements ICarrierDataBaseRepository {

    private final EntityManager em;

    @Autowired
    public JakartaCarrierRepository(EntityManager em) {
        super(JakartaCarrier.class, em);
        this.em = em;
    }

    @Override
    public CarrierBO persist(CarrierBO carrierBO) {
        return null;
    }

}
