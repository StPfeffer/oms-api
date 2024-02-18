package pfeffer.oms.inventory.domain.usecases.channel;

import pfeffer.oms.inventory.domain.dtos.ChannelStockDTO;

import java.util.List;

public interface IChannelStockRepository {

    ChannelStockDTO findChannelStockByChannelId(String channelId);

}
