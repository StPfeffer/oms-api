package pfeffer.oms.inventory.domain.repositories.location;

import pfeffer.oms.inventory.domain.entities.LocationBO;
import pfeffer.oms.inventory.domain.repositories.IAbstractDataBaseRepository;

public interface ILocationDataBaseRepository extends IAbstractDataBaseRepository<LocationBO> {

    LocationBO update(String locationId, LocationBO bo);

}
