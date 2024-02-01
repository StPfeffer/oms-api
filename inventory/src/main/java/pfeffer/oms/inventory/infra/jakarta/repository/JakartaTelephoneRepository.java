package pfeffer.oms.inventory.infra.jakarta.repository;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import pfeffer.oms.inventory.domain.entities.TelephoneBO;
import pfeffer.oms.inventory.domain.repositories.ITelephoneDataBaseRepository;
import pfeffer.oms.inventory.infra.jakarta.mappers.JakartaTelephoneMapper;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaTelephone;

@Service
public class JakartaTelephoneRepository extends SimpleJpaRepository<JakartaTelephone, Long> implements ITelephoneDataBaseRepository {

    private final EntityManager em;

    @Autowired
    public JakartaTelephoneRepository(EntityManager em) {
        super(JakartaTelephone.class, em);
        this.em = em;
    }


    @Override
    public TelephoneBO persist(TelephoneBO bo) {
        JakartaTelephone entity = JakartaTelephoneMapper.toEntity(bo);

        em.persist(entity);
        em.flush();

        return JakartaTelephoneMapper.toDomain(entity);
    }

}
