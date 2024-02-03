package pfeffer.oms.inventory.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pfeffer.oms.inventory.domain.dtos.LocationChannelDTO;
import pfeffer.oms.inventory.services.LocationChannelService;

@RestController
@RequestMapping("locations/channels")
public class LocationChannelController {

    private final LocationChannelService service;

    public LocationChannelController(LocationChannelService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<LocationChannelDTO> createLocationChannel(@RequestBody LocationChannelDTO locationChannel) {
        LocationChannelDTO newLocationChannel = this.service.createChannel(locationChannel);

        return new ResponseEntity<>(newLocationChannel, HttpStatus.CREATED);
    }

}
