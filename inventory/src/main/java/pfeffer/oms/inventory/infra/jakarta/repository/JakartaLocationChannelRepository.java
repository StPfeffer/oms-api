package pfeffer.oms.inventory.infra.jakarta.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import pfeffer.oms.inventory.domain.dtos.LocationChannelDTO;
import pfeffer.oms.inventory.domain.entities.LocationChannelBO;
import pfeffer.oms.inventory.domain.exceptions.ChannelException;
import pfeffer.oms.inventory.domain.mappers.LocationChannelMapper;
import pfeffer.oms.inventory.domain.repositories.location.ILocationChannelDataBaseRepository;
import pfeffer.oms.inventory.domain.repositories.location.ILocationChannelRepository;
import pfeffer.oms.inventory.infra.jakarta.mappers.JakartaLocationChannelMapper;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaChannel;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaLocation;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaLocationChannel;

@Service
public class JakartaLocationChannelRepository extends SimpleJpaRepository<JakartaLocationChannel, Long> implements ILocationChannelDataBaseRepository, ILocationChannelRepository {

    private final EntityManager em;

    private final JakartaLocationRepository locationRepository;

    private final JakartaChannelRepository channelRepository;

    @Autowired
    public JakartaLocationChannelRepository(EntityManager em, JakartaLocationRepository locationRepository, JakartaChannelRepository channelRepository) {
        super(JakartaLocationChannel.class, em);
        this.em = em;
        this.locationRepository = locationRepository;
        this.channelRepository = channelRepository;
    }

    @Override
    public LocationChannelBO persist(LocationChannelBO bo) {
        JakartaLocation location = locationRepository.findEntityByLocationId(bo.getLocationId(), true);
        JakartaChannel channel = channelRepository.findEntityByChannelId(bo.getChannelId(), true);

        JakartaLocationChannel entity = JakartaLocationChannelMapper.toEntity(bo);
        entity.setLocation(location);
        entity.setChannel(channel);

        this.canCreate(entity);

        em.persist(entity);
        em.flush();

        return JakartaLocationChannelMapper.toDomain(entity);
    }

    private void canCreate(JakartaLocationChannel entity) {
        LocationChannelDTO locationChannel = this.findByLocationIdAndChannelId(entity.getLocation().getLocationId(), entity.getChannel().getChannelId());

        if (locationChannel != null) {
            throw new ChannelException("The informed branch is already linked to the informed channel", 409);
        }
    }

    @Override
    public LocationChannelDTO findByLocationIdAndChannelId(String locationId, String channelId) {
        TypedQuery<JakartaLocationChannel> query = em.createQuery("SELECT e FROM JakartaLocationChannel e WHERE e.channel.channelId = :channelId AND e.location.locationId = :locationId", JakartaLocationChannel.class)
                .setParameter("channelId", channelId)
                .setParameter("locationId", locationId);

        try {
            return LocationChannelMapper.toDTO(JakartaLocationChannelMapper.toDomain(query.getSingleResult()));
        } catch (NoResultException e) {
            return null;
        }
    }
}
