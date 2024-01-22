package pfeffer.oms.inventory.jakarta.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import pfeffer.oms.inventory.domain.dtos.ChannelDTO;
import pfeffer.oms.inventory.domain.entities.ChannelBO;
import pfeffer.oms.inventory.domain.mappers.ChannelMapper;
import pfeffer.oms.inventory.domain.repositories.IChannelDataBaseRepository;
import pfeffer.oms.inventory.domain.repositories.IChannelRepository;
import pfeffer.oms.inventory.jakarta.mappers.JakartaChannelMapper;
import pfeffer.oms.inventory.jakarta.model.JakartaChannel;

@Service
public class JakartaChannelRepository extends SimpleJpaRepository<JakartaChannel, Long> implements IChannelDataBaseRepository, IChannelRepository {

    private final EntityManager em;

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
            throw new RuntimeException("Já existe um canal de vendas cadastrado com este nome");
        }
    }

    @Override
    public ChannelDTO findChannelByChannelId(String channelId) {
        TypedQuery<JakartaChannel> query = em.createQuery("SELECT e FROM JakartaChannel e WHERE e.name = :name", JakartaChannel.class)
                .setParameter("name", channelId);

        try {
            return ChannelMapper.toDTO(JakartaChannelMapper.toDomain(query.getSingleResult()));
        } catch (NoResultException e) {
            return null;
        }
    }

}
