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
import pfeffer.oms.inventory.domain.mappers.ChannelMapper;
import pfeffer.oms.inventory.domain.mappers.ChannelStockMapper;
import pfeffer.oms.inventory.domain.repositories.channel.IChannelStockDataBaseRepository;
import pfeffer.oms.inventory.domain.usecases.channel.IChannelStockRepository;
import pfeffer.oms.inventory.infra.jakarta.mappers.JakartaChannelMapper;
import pfeffer.oms.inventory.infra.jakarta.mappers.JakartaChannelStockMapper;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaChannel;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaChannelStock;

import java.util.List;

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
        JakartaChannel channel = this.channelRepository.findJakartaChannelByChannelId(bo.getChannelId());

        if (channel == null) {
            throw new ChannelException("There is no channel registered with the provided id", 404);
        }

        ChannelStockDTO channelStock = this.findChannelStockByChannelId(bo.getChannelId());

        if (channelStock != null) {
            this.update(bo.getChannelId(), bo);
        }

        JakartaChannelStock entity = JakartaChannelStockMapper.toEntity(bo);
        entity.setChannel(channel);

        em.persist(entity);
        em.flush();

        return JakartaChannelStockMapper.toDomain(entity);
    }

    @Override
    public ChannelStockBO update(String channelId, ChannelStockBO bo) {
        JakartaChannelStock channelStock = this.findJakartaChannelStockByChannelId(channelId);

        if (channelStock == null) {
            throw new ChannelException("There is no channel registered with the provided id", 404);
        }

        JakartaChannel channel = JakartaChannelMapper.toEntity(ChannelMapper.toBO(channelRepository.findChannelByChannelId(channelId)));

        JakartaChannelStock entity = JakartaChannelStockMapper.toEntity(bo);
        entity.setId(channelStock.getId());
        entity.setChannel(channel);

        em.merge(entity);
        em.flush();

        return JakartaChannelStockMapper.toDomain(entity);
    }

    @Override
    public List<ChannelStockDTO> findChannelStockTypesByChannelId(String channelId) {
        TypedQuery<JakartaChannelStock> query = em.createQuery("SELECT e FROM JakartaChannelStock e WHERE e.channel.channelId = :channelId", JakartaChannelStock.class)
                .setParameter("channelId", channelId);

        try {
            List<JakartaChannelStock> stockTypes = query.getResultList();

            return stockTypes.stream().map(jakartaChannelStock ->
                    ChannelStockMapper.toDTO(JakartaChannelStockMapper.toDomain(jakartaChannelStock))
            ).toList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public ChannelStockDTO findChannelStockByChannelId(String channelId) {
        TypedQuery<JakartaChannelStock> query = em.createQuery("SELECT e FROM JakartaChannelStock e WHERE e.channel.channelId = :channelId", JakartaChannelStock.class)
                .setParameter("channelId", channelId);

        try {
            return ChannelStockMapper.toDTO(JakartaChannelStockMapper.toDomain(query.getSingleResult()));
        } catch (NoResultException e) {
            return null;
        }
    }

    public JakartaChannelStock findJakartaChannelStockByChannelId(String channelId) {
        TypedQuery<JakartaChannelStock> query = em.createQuery("SELECT e FROM JakartaChannelStock e WHERE e.channel.channelId = :channelId", JakartaChannelStock.class)
                .setParameter("channelId", channelId);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
