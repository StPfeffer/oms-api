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
    public ResponseEntity<ChannelStockDTO> createChannelStock(@RequestBody ChannelStockDTO dto) {
        ChannelStockDTO newChannelStock = this.service.createChannelStock(dto);

        return new ResponseEntity<>(newChannelStock, HttpStatus.CREATED);
    }

    @PutMapping("{channelId}")
    public ResponseEntity<ChannelStockDTO> updateChannelStock(@PathVariable String channelId, @RequestBody ChannelStockDTO dto) {
        ChannelStockDTO updatedChannelStock = this.service.updateChannelStock(channelId, dto);

        return new ResponseEntity<>(updatedChannelStock, HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<ChannelStockDTO>> listChannelStockTypes() {
        List<ChannelStockDTO> stockTypes = this.service.listChannelStockTypes();

        return new ResponseEntity<>(stockTypes, HttpStatus.OK);
    }

}
