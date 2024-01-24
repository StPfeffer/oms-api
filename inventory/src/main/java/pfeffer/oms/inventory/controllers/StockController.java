package pfeffer.oms.inventory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfeffer.oms.inventory.domain.dtos.StockDTO;
import pfeffer.oms.inventory.services.StockService;

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

    @PutMapping("{skuId}")
    public ResponseEntity<StockDTO> updateStock(@PathVariable String skuId, @RequestBody StockDTO stockDTO) {
        StockDTO updatedStock = this.service.updateStock(skuId, stockDTO);

        return new ResponseEntity<>(updatedStock, HttpStatus.ACCEPTED);
    }

}
