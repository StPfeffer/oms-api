package pfeffer.oms.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfeffer.oms.order.domain.dtos.OrderDTO;
import pfeffer.oms.order.service.OrderService;

@RestController
@RequestMapping("channels/{channelId}/orders")
public class OrderController {

    private final OrderService service;

    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@PathVariable String channelId, @RequestBody OrderDTO order) {
        OrderDTO newOrder = this.service.createOrder(channelId, order);

        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    @GetMapping("{orderId}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable String channelId, @PathVariable String orderId) {
        OrderDTO order = this.service.findByOrderIdAndChannelId(orderId, channelId);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

}
