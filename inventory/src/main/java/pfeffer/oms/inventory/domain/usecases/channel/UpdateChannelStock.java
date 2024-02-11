package pfeffer.oms.inventory.domain.usecases.channel;

import pfeffer.oms.inventory.domain.dtos.ChannelStockDTO;
import pfeffer.oms.inventory.domain.entities.ChannelStockBO;
import pfeffer.oms.inventory.domain.mappers.ChannelStockMapper;
import pfeffer.oms.inventory.domain.repositories.channel.IChannelStockDataBaseRepository;

public class UpdateChannelStock {

    private final IChannelStockDataBaseRepository repository;

    public UpdateChannelStock(IChannelStockDataBaseRepository repository) {
        this.repository = repository;
    }

    public ChannelStockDTO execute(ChannelStockDTO dto) {
        ChannelStockBO entity = repository.update(dto.getChannelId(), ChannelStockMapper.toBO(dto));

        return ChannelStockMapper.toDTO(entity);
    }

}
