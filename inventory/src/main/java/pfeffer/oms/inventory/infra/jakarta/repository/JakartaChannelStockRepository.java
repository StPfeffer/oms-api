package pfeffer.oms.inventory.infra.jakarta.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import pfeffer.oms.inventory.domain.dtos.ChannelStockDTO;
import pfeffer.oms.inventory.domain.entities.ChannelStockBO;
import pfeffer.oms.inventory.domain.exceptions.ChannelException;
import pfeffer.oms.inventory.domain.mappers.ChannelStockMapper;
import pfeffer.oms.inventory.domain.repositories.channel.IChannelStockDataBaseRepository;
import pfeffer.oms.inventory.domain.usecases.channel.IChannelStockRepository;
import pfeffer.oms.inventory.infra.jakarta.mappers.JakartaChannelStockMapper;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaChannel;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaChannelStock;

@Service
public class JakartaChannelStockRepository extends SimpleJpaRepository<JakartaChannelStock, Long> implements IChannelStockDataBaseRepository, IChannelStockRepository {

    private final EntityManager em;

    private final JakartaChannelRepository channelRepository;

    @Autowired
    public JakartaChannelStockRepository(EntityManager em, JakartaChannelRepository channelRepository) {
        super(JakartaChannelStock.class, em);
        this.em = em;
        this.channelRepository = channelRepository;
    }

    @Override
    public ChannelStockBO persist(ChannelStockBO bo) {
        JakartaChannel channel = this.channelRepository.findEntityByChannelId(bo.getChannelId(), true);

        JakartaChannelStock channelStock = this.findEntityByChannelId(bo.getChannelId());

        // auto update
        if (channelStock != null) {
            return this.update(bo.getChannelId(), bo);
        }

        JakartaChannelStock entity = JakartaChannelStockMapper.toEntity(bo);
        entity.setChannel(channel);

        em.persist(entity);
        em.flush();

        return JakartaChannelStockMapper.toDomain(entity);
    }

    @Override
    public ChannelStockBO update(String channelId, ChannelStockBO bo) {
        JakartaChannelStock channelStock = this.findEntityByChannelId(channelId);

        if (channelStock == null) {
            throw ChannelException.NOT_FOUND;
        }

        channelStock.setStockTypes(bo.getStockTypes());

        return JakartaChannelStockMapper.toDomain(channelStock);
    }

    @Override
    public ChannelStockDTO findByChannelId(String channelId) {
        JakartaChannelStock entity = this.findEntityByChannelId(channelId);

        try {
            return ChannelStockMapper.toDTO(JakartaChannelStockMapper.toDomain(entity));
        } catch (NoResultException e) {
            return null;
        }
    }

    public JakartaChannelStock findEntityByChannelId(String channelId) {
        TypedQuery<JakartaChannelStock> query = em.createQuery("SELECT e FROM JakartaChannelStock e WHERE e.channel.channelId = :channelId", JakartaChannelStock.class)
                .setParameter("channelId", channelId);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
