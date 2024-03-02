package pfeffer.oms.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pfeffer.oms.order.domain.dtos.OrderDTO;
import pfeffer.oms.order.service.OrderService;

@RestController
@RequestMapping("orders")
public class OrderController {

    private final OrderService service;

    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO order) {
        OrderDTO newOrder = this.service.createOrder(order);

        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

}
