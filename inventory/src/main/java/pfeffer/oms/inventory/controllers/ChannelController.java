package pfeffer.oms.inventory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfeffer.oms.inventory.domain.dtos.ChannelDTO;
import pfeffer.oms.inventory.services.ChannelService;

import java.util.List;

@RestController
@RequestMapping("channels")
public class ChannelController {

    private final ChannelService service;

    @Autowired
    public ChannelController(ChannelService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ChannelDTO> createChannel(@RequestBody ChannelDTO channel) {
        ChannelDTO newChannel = this.service.createChannel(channel);

        return new ResponseEntity<>(newChannel, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ChannelDTO>> listChannels() {
        List<ChannelDTO> channels = this.service.listChannels();

        return new ResponseEntity<>(channels, HttpStatus.OK);
    }

    @GetMapping("{channelId}")
    public ResponseEntity<ChannelDTO> getChannel(@PathVariable String channelId) {
        ChannelDTO channel = this.service.findByChannelId(channelId);

        return new ResponseEntity<>(channel, HttpStatus.OK);
    }

}
