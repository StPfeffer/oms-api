package pfeffer.oms.inventory.domain.usecases;

import pfeffer.oms.inventory.domain.dtos.LocationDTO;
import pfeffer.oms.inventory.domain.entities.LocationBO;
import pfeffer.oms.inventory.domain.mappers.LocationMapper;
import pfeffer.oms.inventory.domain.repositories.ILocationDataBaseRepository;

public class CreateLocation {

    private final ILocationDataBaseRepository repository;

    public CreateLocation(ILocationDataBaseRepository repository) {
        this.repository = repository;
    }

    public LocationDTO execute(LocationDTO dto) {
        LocationBO entity = repository.persist(LocationMapper.toBO(dto));

        return LocationMapper.toDTO(entity);
    }

}
