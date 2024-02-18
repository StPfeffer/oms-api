package pfeffer.oms.order.infra.jakarta.repository;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import pfeffer.oms.order.domain.entities.PaymentBO;
import pfeffer.oms.order.domain.repositories.IPaymentDataBaseRepository;
import pfeffer.oms.order.infra.jakarta.mappers.JakartaPaymentMapper;
import pfeffer.oms.order.infra.jakarta.model.JakartaPayment;

@Service
public class JakartaPaymentRepository extends SimpleJpaRepository<JakartaPayment, Long> implements IPaymentDataBaseRepository {

    private final EntityManager em;

    @Autowired
    public JakartaPaymentRepository(EntityManager em) {
        super(JakartaPayment.class, em);
        this.em = em;
    }

    @Override
    public PaymentBO persist(PaymentBO bo) {
        JakartaPayment entity = JakartaPaymentMapper.toEntity(bo);

        em.persist(entity);
        em.flush();

        return JakartaPaymentMapper.toDomain(entity);
    }

}
