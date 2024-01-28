package pfeffer.oms.inventory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfeffer.oms.inventory.domain.dtos.LocationDTO;
import pfeffer.oms.inventory.services.LocationService;

import java.util.List;

@RestController
@RequestMapping("locations")
public class LocationController {

    private final LocationService service;

    @Autowired
    public LocationController(LocationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<LocationDTO> createLocation(@RequestBody LocationDTO location) {
        LocationDTO newLocation = this.service.createLocation(location);

        return new ResponseEntity<>(newLocation, HttpStatus.CREATED);
    }

    @PutMapping("{locationId}")
    public ResponseEntity<LocationDTO> updateLocation(@PathVariable String locationId, @RequestBody LocationDTO location) {
        LocationDTO updatedLocation = this.service.updateLocation(locationId, location);

        return new ResponseEntity<>(updatedLocation, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LocationDTO>> listLocations() {
        List<LocationDTO> locations = this.service.listLocations();

        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @GetMapping("{locationId}")
    public ResponseEntity<LocationDTO> getLocation(@PathVariable String locationId) {
        LocationDTO location = this.service.findLocationByLocationId(locationId);

        return new ResponseEntity<>(location, HttpStatus.OK);
    }

}
