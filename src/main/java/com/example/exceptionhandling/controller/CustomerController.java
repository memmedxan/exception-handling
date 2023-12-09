package com.example.exceptionhandling.controller;


import com.example.exceptionhandling.entity.Customer;
import com.example.exceptionhandling.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

@Autowired
    CustomerService customerService;


    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
    Customer addCustomer = customerService.addCustomer(customer);
    return new ResponseEntity<Customer>(addCustomer, HttpStatus.CREATED);

}

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        List <Customer> allCustomer = customerService.findAllCustomer();
        return new ResponseEntity<List<Customer>>(allCustomer, HttpStatus.OK);


    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable ("id")Long id){
        Customer customerId = customerService.getCustomerById(id);
        return new ResponseEntity<Customer>(customerId,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable ("id") Long id){
        customerService.deleteCustomerById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);


    }
}
