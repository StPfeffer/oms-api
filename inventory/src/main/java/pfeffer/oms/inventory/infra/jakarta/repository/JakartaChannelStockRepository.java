package pfeffer.oms.inventory.infra.jakarta.repository;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import pfeffer.oms.inventory.domain.entities.ChannelStockBO;
import pfeffer.oms.inventory.domain.repositories.channel.IChannelStockDataBaseRepository;
import pfeffer.oms.inventory.infra.jakarta.mappers.JakartaChannelStockMapper;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaChannelStock;

@Service
public class JakartaChannelStockRepository extends SimpleJpaRepository<JakartaChannelStock, Long> implements IChannelStockDataBaseRepository {

    private final EntityManager em;

    @Autowired
    public JakartaChannelStockRepository(EntityManager em) {
        super(JakartaChannelStock.class, em);
        this.em = em;
    }

    @Override
    public ChannelStockBO persist(ChannelStockBO bo) {
        JakartaChannelStock entity = JakartaChannelStockMapper.toEntity(bo);

        em.persist(entity);
        em.flush();

        return JakartaChannelStockMapper.toDomain(entity);
    }

}
