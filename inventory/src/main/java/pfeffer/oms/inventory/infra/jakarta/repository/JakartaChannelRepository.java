package pfeffer.oms.inventory.infra.jakarta.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import pfeffer.oms.inventory.domain.dtos.ChannelDTO;
import pfeffer.oms.inventory.domain.entities.ChannelBO;
import pfeffer.oms.inventory.domain.exceptions.ChannelException;
import pfeffer.oms.inventory.domain.mappers.ChannelMapper;
import pfeffer.oms.inventory.domain.repositories.channel.IChannelDataBaseRepository;
import pfeffer.oms.inventory.domain.repositories.channel.IChannelRepository;
import pfeffer.oms.inventory.infra.jakarta.mappers.JakartaChannelMapper;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaChannel;

@Service
public class JakartaChannelRepository extends SimpleJpaRepository<JakartaChannel, Long> implements IChannelDataBaseRepository, IChannelRepository {

    private final EntityManager em;

    @Autowired
    public JakartaChannelRepository(EntityManager em) {
        super(JakartaChannel.class, em);
        this.em = em;
    }

    @Override
    public ChannelBO persist(ChannelBO bo) {
        JakartaChannel entity = JakartaChannelMapper.toEntity(bo);

        this.canCreate(entity);

        em.persist(entity);
        em.flush();

        return JakartaChannelMapper.toDomain(entity);
    }

    public void canCreate(JakartaChannel entity) {
        ChannelDTO channel = this.findChannelByChannelId(entity.getChannelId());

        if (channel != null) {
            throw ChannelException.ALREADY_EXISTS;
        }
    }

    @Override
    public ChannelDTO findChannelByChannelId(String channelId) {
        TypedQuery<JakartaChannel> query = em.createQuery("SELECT e FROM JakartaChannel e WHERE e.channelId = :channelId", JakartaChannel.class)
                .setParameter("channelId", channelId);

        try {
            return ChannelMapper.toDTO(JakartaChannelMapper.toDomain(query.getSingleResult()));
        } catch (NoResultException e) {
            return null;
        }
    }

    public JakartaChannel findJakartaChannelByChannelId(String channelId) {
        return this.findJakartaChannelByChannelId(channelId, false);
    }

    public JakartaChannel findJakartaChannelByChannelId(String channelId, boolean exception) {
        TypedQuery<JakartaChannel> query = em.createQuery("SELECT e FROM JakartaChannel e WHERE e.channelId = :channelId", JakartaChannel.class)
                .setParameter("channelId", channelId);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            if (exception) {
                throw ChannelException.NOT_FOUND;
            }

            return null;
        }
    }

}
