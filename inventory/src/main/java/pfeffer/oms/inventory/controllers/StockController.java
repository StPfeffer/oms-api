package pfeffer.oms.inventory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfeffer.oms.inventory.domain.dtos.StockDTO;
import pfeffer.oms.inventory.services.StockService;

import java.util.List;

@RestController
@RequestMapping("stock")
public class StockController {

    private final StockService service;

    @Autowired
    public StockController(StockService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StockDTO> createStock(@RequestBody StockDTO stock) {
        StockDTO newStock = this.service.createStock(stock);

        return new ResponseEntity<>(newStock, HttpStatus.CREATED);
    }

    @PutMapping("{locationId}/{skuId}")
    public ResponseEntity<StockDTO> updateStock(@PathVariable String locationId, @PathVariable String skuId, @RequestBody StockDTO stockDTO) {
        StockDTO updatedStock = this.service.updateStock(locationId, skuId, stockDTO);

        return new ResponseEntity<>(updatedStock, HttpStatus.ACCEPTED);
    }

    @GetMapping("{skuId}")
    public ResponseEntity<List<StockDTO>> listStock(@PathVariable String skuId) {
        List<StockDTO> stocks = this.service.listBySkuId(skuId);

        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    @GetMapping("{locationId}/{skuId}")
    public ResponseEntity<StockDTO> getStock(@PathVariable String locationId, @PathVariable String skuId) {
        StockDTO stock = this.service.findBySkuIdAndLocationId(skuId, locationId);

        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

}
