package pfeffer.oms.inventory.domain.usecases.create;

import pfeffer.oms.inventory.domain.dtos.ChannelDTO;
import pfeffer.oms.inventory.domain.entities.ChannelBO;
import pfeffer.oms.inventory.domain.mappers.ChannelMapper;
import pfeffer.oms.inventory.domain.repositories.IChannelDataBaseRepository;

public class CreateChannel extends AbstractCreateUseCase<ChannelDTO, ChannelBO, ChannelMapper, IChannelDataBaseRepository> {

    public CreateChannel(IChannelDataBaseRepository repository) {
        super(repository, new ChannelMapper());
    }

}
