package pfeffer.oms.inventory.domain.usecases.channel;

import pfeffer.oms.inventory.domain.dtos.ChannelStockDTO;

public interface IChannelStockRepository {

    ChannelStockDTO findByChannelId(String channelId);

}
