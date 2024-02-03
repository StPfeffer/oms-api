package pfeffer.oms.inventory.domain.usecases;

import pfeffer.oms.inventory.domain.dtos.LocationChannelDTO;
import pfeffer.oms.inventory.domain.entities.LocationChannelBO;
import pfeffer.oms.inventory.domain.mappers.LocationChannelMapper;
import pfeffer.oms.inventory.domain.repositories.ILocationChannelDataBaseRepository;

public class CreateLocationChannel {

    private final ILocationChannelDataBaseRepository repository;

    public CreateLocationChannel(ILocationChannelDataBaseRepository repository) {
        this.repository = repository;
    }

    public LocationChannelDTO execute(LocationChannelDTO dto) {
        LocationChannelBO entity = repository.persist(LocationChannelMapper.toBO(dto));

        return LocationChannelMapper.toDTO(entity);
    }

}