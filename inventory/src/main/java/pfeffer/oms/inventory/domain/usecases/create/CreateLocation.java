package pfeffer.oms.inventory.domain.usecases.create;

import pfeffer.oms.inventory.domain.dtos.LocationDTO;
import pfeffer.oms.inventory.domain.entities.LocationBO;
import pfeffer.oms.inventory.domain.mappers.LocationMapper;
import pfeffer.oms.inventory.domain.repositories.ILocationDataBaseRepository;

public class CreateLocation extends AbstractCreateUseCase<LocationDTO, LocationBO, LocationMapper, ILocationDataBaseRepository> {

    public CreateLocation(ILocationDataBaseRepository repository) {
        super(repository, new LocationMapper());
    }

}
