package pfeffer.oms.inventory.domain.repositories;

import pfeffer.oms.inventory.domain.entities.ChannelBO;

public interface IChannelDataBaseRepository {

    ChannelBO persist(ChannelBO bo);

}
