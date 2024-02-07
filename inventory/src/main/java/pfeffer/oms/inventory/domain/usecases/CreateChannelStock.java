package pfeffer.oms.inventory.domain.usecases;

import pfeffer.oms.inventory.domain.dtos.ChannelStockDTO;
import pfeffer.oms.inventory.domain.entities.ChannelStockBO;
import pfeffer.oms.inventory.domain.mappers.ChannelStockMapper;
import pfeffer.oms.inventory.domain.repositories.IChannelStockDataBaseRepository;

public class CreateChannelStock {

    private final IChannelStockDataBaseRepository repository;

    public CreateChannelStock(IChannelStockDataBaseRepository repository) {
        this.repository = repository;
    }

    public ChannelStockDTO execute(ChannelStockDTO dto) {
        ChannelStockBO entity = repository.persist(ChannelStockMapper.toBO(dto));

        return ChannelStockMapper.toDTO(entity);
    }

}
