package pfeffer.oms.inventory.domain.repositories.location;

import pfeffer.oms.inventory.domain.dtos.LocationDTO;

public interface ILocationRepository {

    LocationDTO findByLocationId(String locationId);

}
