package com.dm.demo2.controller;

import com.dm.demo2.Service.CustomerService;
import com.dm.demo2.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v2")
public class RegisterController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@RequestBody Customer customer){

        ResponseEntity<String> response = null;
        try{
            Customer savecustomer = customerService.createCustomer(customer);
            if(savecustomer.getId() > 0){
                response = ResponseEntity.status(HttpStatus.CREATED)
                        .body("Customer is created successfully for customer = "+ customer.getUsername());
            }
        }catch(Exception exception){
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred from server with exception = " + exception);
        }
        return response;
    }
}
//ok
