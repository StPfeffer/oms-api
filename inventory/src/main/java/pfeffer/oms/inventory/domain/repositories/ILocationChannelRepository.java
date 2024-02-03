package pfeffer.oms.inventory.domain.repositories;

import pfeffer.oms.inventory.domain.dtos.LocationChannelDTO;

public interface ILocationChannelRepository {

    LocationChannelDTO findLocationChannelByLocationIdAndChannelId(String locationId, String channelId);

}
