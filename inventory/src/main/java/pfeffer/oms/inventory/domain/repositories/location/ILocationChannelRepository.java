package pfeffer.oms.inventory.domain.repositories.location;

import pfeffer.oms.inventory.domain.dtos.LocationChannelDTO;

public interface ILocationChannelRepository {

    LocationChannelDTO findByLocationIdAndChannelId(String locationId, String channelId);

}
