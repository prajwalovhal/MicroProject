package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Customer;
import com.csi.repo.CustomerRepo;
import com.csi.service.CustomerServiceImpl;
import com.csi.vo.RestTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    CustomerServiceImpl customerServiceImpl;

    @PostMapping("/signup")
    public ResponseEntity<Customer> signUp(@Valid @RequestBody Customer customer){
        return new ResponseEntity<>(customerServiceImpl.signUp(customer), HttpStatus.CREATED);

    }

    @GetMapping("/{custId}")
    public ResponseEntity<RestTemplateVO> getDataById(@PathVariable long custId){
        return ResponseEntity.ok(customerServiceImpl.getDataById(custId));
    }

    @GetMapping("/signin/{custEmailId}/{custPassword}")
    public ResponseEntity<Boolean> signIn(@PathVariable String custEmailId, @PathVariable String custPassword){
        return ResponseEntity.ok(customerServiceImpl.signIn(custEmailId, custPassword));
    }

    @GetMapping("/getdatabyemailid/{custEmailId}")
    public ResponseEntity<Customer> getDataByEmailId(@PathVariable String custEmailId){
        return ResponseEntity.ok(customerServiceImpl.getDataByEmailId(custEmailId));
    }

    @PutMapping("/updatedata/{custId}")
    public ResponseEntity<Customer> updateData(@PathVariable long custId, @RequestBody Customer customer){

        //  getDatById from DB == UI-> Id
        // if()-> update data
        // else -> throw Exception

        Customer customer1 = customerRepo.findById(custId).orElseThrow(()-> new RecordNotFoundException("Customer Id Does Not Exist"));

        customer1.setCustName(customer.getCustName());
        customer1.setCustDOB(customer.getCustDOB());
        customer1.setCustContactNumber(customer.getCustContactNumber());
        customer1.setCustAddress(customer.getCustAddress());
        customer1.setCustPassword(customer.getCustPassword());
        customer1.setCustEmailId(customer.getCustEmailId());
        return ResponseEntity.ok(customerServiceImpl.updateData(customer1));
    }

    @DeleteMapping("/{custId}")
    public ResponseEntity<String> deleteData(@PathVariable long custId){
        customerServiceImpl.deleteData(custId);
        return ResponseEntity.ok("Data Deleted Successfully");
    }

}
