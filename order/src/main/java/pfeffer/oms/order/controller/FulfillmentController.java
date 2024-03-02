package pfeffer.oms.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfeffer.oms.order.domain.dtos.FulfillmentDTO;
import pfeffer.oms.order.service.FulfillmentService;

import java.util.List;

@RestController
@RequestMapping("channels/{channelId}/orders/{orderId}/fulfillments")
public class FulfillmentController {

    private final FulfillmentService service;

    @Autowired
    public FulfillmentController(FulfillmentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FulfillmentDTO> createFulfillment(@PathVariable String channelId, @PathVariable String orderId, @RequestBody FulfillmentDTO fulfillment) {
        FulfillmentDTO newFulfillment = this.service.createFulfillment(channelId, orderId, fulfillment);

        return new ResponseEntity<>(newFulfillment, HttpStatus.CREATED);
    }

    @GetMapping("{fulfillmentId}")
    public ResponseEntity<FulfillmentDTO> getFulfillment(@PathVariable String channelId, @PathVariable String orderId, @PathVariable String fulfillmentId) {
        FulfillmentDTO fulfillment = this.service.findByOrderIdChannelIdFulfillmentId(channelId, orderId, fulfillmentId);

        return new ResponseEntity<>(fulfillment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FulfillmentDTO>> listFulfillments(@PathVariable String channelId, @PathVariable String orderId) {
        List<FulfillmentDTO> fulfillments = this.service.listAllByOrderIdAndChannelid(channelId, orderId);

        return new ResponseEntity<>(fulfillments, HttpStatus.CREATED);
    }

}
