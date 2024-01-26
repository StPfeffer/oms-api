package pfeffer.oms.inventory.domain.usecases.update;

import pfeffer.oms.inventory.domain.dtos.LocationDTO;
import pfeffer.oms.inventory.domain.entities.LocationBO;
import pfeffer.oms.inventory.domain.mappers.LocationMapper;
import pfeffer.oms.inventory.domain.repositories.ILocationDataBaseRepository;

public class UpdateLocation extends AbstractUpdateUseCase<LocationDTO, LocationBO, LocationMapper, ILocationDataBaseRepository> {

    public UpdateLocation(ILocationDataBaseRepository repository) {
        super(repository, new LocationMapper());
    }

}
