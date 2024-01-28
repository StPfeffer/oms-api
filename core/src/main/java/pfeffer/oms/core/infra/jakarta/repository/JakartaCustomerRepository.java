package pfeffer.oms.core.infra.jakarta.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import pfeffer.oms.core.domain.dtos.CustomerDTO;
import pfeffer.oms.core.domain.entities.CustomerBO;
import pfeffer.oms.core.domain.mappers.CustomerMapper;
import pfeffer.oms.core.domain.repositories.ICustomerDataBaseRepository;
import pfeffer.oms.core.domain.repositories.ICustomerRepository;
import pfeffer.oms.core.infra.jakarta.mappers.JakartaCustomerMapper;
import pfeffer.oms.core.infra.jakarta.model.JakartaCustomer;


@Service
public class JakartaCustomerRepository extends SimpleJpaRepository<JakartaCustomer, Long> implements ICustomerDataBaseRepository, ICustomerRepository {

    private final EntityManager em;

    @Autowired
    public JakartaCustomerRepository(EntityManager em) {
        super(JakartaCustomer.class, em);
        this.em = em;
    }

    @Override
    public CustomerBO persist(CustomerBO bo) {
        CustomerDTO customer = this.findCustomerById(bo.getId());

        if (customer != null) {
            throw new RuntimeException("Já existe um cliente cadastrado com esse ID");
        }

        JakartaCustomer entity = JakartaCustomerMapper.toEntity(bo);

        em.persist(entity);
        em.flush();

        return JakartaCustomerMapper.toDomain(entity);
    }

    @Override
    public CustomerBO update(String customerId, CustomerBO bo) {
        CustomerDTO customer = this.findCustomerById(customerId);

        if (customer == null) {
            throw new RuntimeException("Não existe um cliente cadastrado com esse ID");
        }

        bo.setId(customerId);

        JakartaCustomer entity = JakartaCustomerMapper.toEntity(bo);

        em.merge(entity);
        em.flush();

        return JakartaCustomerMapper.toDomain(entity);
    }

    @Override
    public CustomerDTO findCustomerById(String customerId) {
        TypedQuery<JakartaCustomer> query = em.createQuery("SELECT e FROM JakartaCustomer e WHERE e.customerId = :customerId", JakartaCustomer.class)
                .setParameter("customerId", customerId);

        try {
            return CustomerMapper.toDTO(JakartaCustomerMapper.toDomain(query.getSingleResult()));
        } catch (NoResultException e) {
            return null;
        }
    }

}
