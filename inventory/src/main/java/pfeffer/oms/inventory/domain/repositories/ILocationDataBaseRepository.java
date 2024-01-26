package pfeffer.oms.inventory.domain.repositories;

import pfeffer.oms.core.domain.repositories.IAbstractDataBaseRepository;
import pfeffer.oms.inventory.domain.entities.LocationBO;

public interface ILocationDataBaseRepository extends IAbstractDataBaseRepository<LocationBO> {

    LocationBO update(String locationId, LocationBO bo);

}
