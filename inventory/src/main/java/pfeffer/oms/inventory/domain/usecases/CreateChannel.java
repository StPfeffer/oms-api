package pfeffer.oms.inventory.domain.usecases;

import pfeffer.oms.inventory.domain.dtos.ChannelDTO;
import pfeffer.oms.inventory.domain.entities.ChannelBO;
import pfeffer.oms.inventory.domain.mappers.ChannelMapper;
import pfeffer.oms.inventory.domain.repositories.IChannelDataBaseRepository;

public class CreateChannel {

    private final IChannelDataBaseRepository repository;

    public CreateChannel(IChannelDataBaseRepository repository) {
        this.repository = repository;
    }

    public ChannelDTO execute(ChannelDTO dto) {
        ChannelBO entity = repository.persist(ChannelMapper.toBO(dto));

        return ChannelMapper.toDTO(entity);
    }

}
