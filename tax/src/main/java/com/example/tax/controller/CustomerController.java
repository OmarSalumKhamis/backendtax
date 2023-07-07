package com.example.tax.controller;

import com.example.tax.model.Customer;
import com.example.tax.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslJpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class CustomerController {
    @Autowired
    private CustomerRepository repository;

    @GetMapping("/customer")
    public List<Customer> fetchAllCustomer()  { return repository.findAll(); }
    @PostMapping("/customer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return repository.save(customer);}
    @GetMapping("/customer/{custid}")
    public ResponseEntity<Customer> fetchById(@PathVariable Integer custid) {
        Customer customer = repository. findById(custid).
                orElseThrow(() -> new RuntimeException("Customer doesnot exist" +custid));
        return ResponseEntity.ok(customer);
    }
//
//    @GetMapping("/customer/{name}")
//     public  String getCustomerByName(@PathVariable String name){
//        String customer = repository.findByName(name).getName();
//      return   "customername was get succesful"+name;
//
//     }

    @PutMapping("/customer/{custid}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Integer custid, @RequestBody Customer customerDetails) {
        Customer customer = repository.findById(custid).get();
        customer.setName(customerDetails.getName());
        customer.setPhone(customerDetails.getPhone());
        customer.setEmail(customerDetails.getEmail());
        customer.setAddress((customerDetails.getAddress()));
        customer.setGender(customerDetails.getGender());
        Customer updateCustomer = repository.save(customer);
        return ResponseEntity.ok(updateCustomer);

    }

    @DeleteMapping("/customer/{id}")
    private void deleteCustomer(@PathVariable Integer id) {repository. deleteById(id);}
}

