package pfeffer.oms.inventory.domain.repositories.channel;

import pfeffer.oms.inventory.domain.dtos.ChannelDTO;

public interface IChannelRepository {

    ChannelDTO findByChannelId(String channelId);

}
