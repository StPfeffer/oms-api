package pfeffer.oms.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfeffer.oms.core.domain.dtos.CustomerDTO;
import pfeffer.oms.core.services.CustomerService;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customer) {
        CustomerDTO newCustomer = this.service.createCustomer(customer);

        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @PutMapping("{customerId}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable String customerId, @RequestBody CustomerDTO customer) {
        CustomerDTO updatedCustomer = this.service.updateCustomer(customerId, customer);

        return new ResponseEntity<>(updatedCustomer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> listCustomers() {
        List<CustomerDTO> customers = this.service.listCustomers();

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("{customerId}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable String customerId) {
        CustomerDTO customer = this.service.findCustomerById(customerId);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

}
