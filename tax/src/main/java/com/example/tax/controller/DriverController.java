package com.example.tax.controller;

import com.example.tax.model.Driver;
import com.example.tax.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1")
public class DriverController {
    @Autowired
    private DriverRepository repository;
    @GetMapping("/getDriver")
    public List<Driver> fetchAllDriver() { return repository.findAll();}

    @PostMapping("/saveDriver")
    public Driver addDriver(@RequestBody Driver driver) { return repository.save(driver);}

    @GetMapping("/getdriver/{id}")
    public ResponseEntity<Driver> fetchById(@PathVariable Integer id){
        Driver driver = repository.findById(id).
                orElseThrow(()->new RuntimeException("driver doesnot exist" +id));
        return ResponseEntity.ok(driver);

    }
    @PutMapping("/driver/{id}")
public ResponseEntity<Driver>udateDriver(@PathVariable Integer id, @RequestBody Driver driverDetails){
        Driver driver = repository.findById(id).orElseThrow(()->new  RuntimeException("id doesnot exist" +id));
        driver.setName(driverDetails.getName());
        driver.setAddress(driverDetails.getAddress());
        driver.setPhone(driverDetails.getPhone());
        driver.setGender(driverDetails.getGender());
        driver.setEmail(driverDetails.getEmail());
        Driver updateDriver = repository.save(driver);
        return ResponseEntity.ok(updateDriver);

}
@DeleteMapping("driver/{id}")
public void deleteDriver(@PathVariable Integer id) {repository.deleteById(id);}
}
