package pfeffer.oms.inventory.domain.repositories;

import pfeffer.oms.inventory.domain.dtos.ChannelDTO;

public interface IChannelRepository {

    ChannelDTO findChannelByName(String name);

}
