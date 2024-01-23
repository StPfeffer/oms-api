package pfeffer.oms.inventory.domain.usecases;

import pfeffer.oms.inventory.domain.dtos.LocationDTO;
import pfeffer.oms.inventory.domain.entities.LocationBO;
import pfeffer.oms.inventory.domain.mappers.LocationMapper;
import pfeffer.oms.inventory.domain.repositories.ILocationDataBaseRepository;

public class UpdateLocation {

    private final ILocationDataBaseRepository repository;

    public UpdateLocation(ILocationDataBaseRepository repository) {
        this.repository = repository;
    }

    public LocationDTO execute(String locationId, LocationDTO dto) {
        LocationBO entity = repository.update(locationId, LocationMapper.toBO(dto));

        return LocationMapper.toDTO(entity);
    }

}