package pfeffer.oms.inventory.domain.repositories;

import pfeffer.oms.inventory.domain.entities.LocationBO;

public interface ILocationDataBaseRepository extends IAbstractDataBaseRepository<LocationBO> {

    LocationBO update(String locationId, LocationBO bo);

}
