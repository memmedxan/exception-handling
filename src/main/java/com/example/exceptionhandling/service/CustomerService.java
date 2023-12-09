package com.example.exceptionhandling.service;


import com.example.exceptionhandling.entity.Customer;
import com.example.exceptionhandling.exception.CustomerNotByIdException;
import com.example.exceptionhandling.exception.CustomerNullException;
import com.example.exceptionhandling.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {


    @Autowired
    CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer){
        if (customer.getName().isBlank() || customer.getName().isEmpty()){
            throw new CustomerNullException("Customer name must be Not Null. ");
        }

        return customerRepository.save(customer);
    }

    public List<Customer> findAllCustomer(){
        return customerRepository.findAll();
    }
        public Customer getCustomerById(Long customerId){
            Optional <Customer> optionalCustomer = customerRepository.findById(customerId);
            Customer customer = optionalCustomer.
                    orElseThrow(()->new CustomerNotByIdException("Customer ID : " +
                    customerId));
            return customer;

        }

        public void deleteCustomerById(Long customerId){
        customerRepository.deleteById(customerId);

        }

}
