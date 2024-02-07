package pfeffer.oms.inventory.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfeffer.oms.inventory.domain.dtos.LocationChannelDTO;
import pfeffer.oms.inventory.domain.exceptions.ChannelException;
import pfeffer.oms.inventory.domain.repositories.location.ILocationChannelRepository;
import pfeffer.oms.inventory.domain.usecases.location.CreateLocationChannel;
import pfeffer.oms.inventory.infra.jakarta.repository.JakartaLocationChannelRepository;

@Service
public class LocationChannelService implements ILocationChannelRepository {

    private final JakartaLocationChannelRepository repository;

    @Autowired
    public LocationChannelService(JakartaLocationChannelRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public LocationChannelDTO createChannel(LocationChannelDTO dto) {
        CreateLocationChannel createChannel = new CreateLocationChannel(repository);

        return createChannel.execute(dto);
    }

    @Override
    public LocationChannelDTO findLocationChannelByLocationIdAndChannelId(String locationId, String channelId) {
        LocationChannelDTO locationChannel = this.repository.findLocationChannelByLocationIdAndChannelId(locationId, channelId);

        if (locationChannel == null) {
            throw new ChannelException("There is no branch with the provided ID associated with the provided channel", 400);
        }

        return locationChannel;
    }

}
