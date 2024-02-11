package pfeffer.oms.inventory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfeffer.oms.inventory.domain.dtos.ChannelStockDTO;
import pfeffer.oms.inventory.services.ChannelStockService;

import java.util.List;

@RestController
@RequestMapping("channels/stocks")
public class ChannelStockController {

    private final ChannelStockService service;

    @Autowired
    public ChannelStockController(ChannelStockService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ChannelStockDTO> createChannel(@RequestBody ChannelStockDTO channel) {
        ChannelStockDTO newChannel = this.service.createChannelStock(channel);

        return new ResponseEntity<>(newChannel, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ChannelStockDTO>> listChannels() {
        List<ChannelStockDTO> channels = this.service.listChannelStockTypes();

        return new ResponseEntity<>(channels, HttpStatus.OK);
    }

}
