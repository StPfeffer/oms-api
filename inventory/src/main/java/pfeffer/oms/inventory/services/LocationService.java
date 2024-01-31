package pfeffer.oms.inventory.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfeffer.oms.inventory.domain.dtos.LocationDTO;
import pfeffer.oms.inventory.domain.exceptions.LocationException;
import pfeffer.oms.inventory.domain.mappers.LocationMapper;
import pfeffer.oms.inventory.domain.repositories.ILocationRepository;
import pfeffer.oms.inventory.domain.usecases.CreateLocation;
import pfeffer.oms.inventory.domain.usecases.UpdateLocation;
import pfeffer.oms.inventory.infra.jakarta.mappers.JakartaLocationMapper;
import pfeffer.oms.inventory.infra.jakarta.repository.JakartaLocationRepository;

import java.util.List;

@Service
public class LocationService implements ILocationRepository {

    private final JakartaLocationRepository repository;

    @Autowired
    public LocationService(JakartaLocationRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public LocationDTO createLocation(LocationDTO dto) {
        CreateLocation createLocation = new CreateLocation(repository);

        return createLocation.execute(dto);
    }

    @Transactional
    public LocationDTO updateLocation(String locationId, LocationDTO dto) {
        UpdateLocation updateLocation = new UpdateLocation(repository);

        return updateLocation.execute(locationId, dto);
    }

    public List<LocationDTO> listLocations() {
        return this.repository.findAll().stream().map(jakartaLocation ->
                LocationMapper.toDTO(JakartaLocationMapper.toDomain(jakartaLocation))
        ).toList();
    }

    @Override
    public LocationDTO findLocationByLocationId(String locationId) {
        LocationDTO location = this.repository.findLocationByLocationId(locationId);

        if (location == null) {
            throw new LocationException("There is no branch registered with the provided id", 404);
        }

        return location;
    }

}
