package com.example.MCDAHotelApi.controller;

import com.example.MCDAHotelApi.model.CustomerModel;
import com.example.MCDAHotelApi.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerModel> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerModel> getCustomerById(@PathVariable Long id) {
        Optional<CustomerModel> customer = customerService.getCustomerById(id);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CustomerModel> createCustomer(@RequestBody CustomerModel customerModel) {
        CustomerModel createdCustomer = customerService.createCustomer(customerModel);
        return ResponseEntity.status(201).body(createdCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        boolean isDeleted = customerService.deleteCustomer(id);
        return isDeleted ? ResponseEntity.ok("Customer deleted successfully") : ResponseEntity.notFound().build();
    }
}
