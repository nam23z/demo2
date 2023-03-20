package com.dm.demo2.Service;

import com.dm.demo2.model.Customer;


import com.dm.demo2.repository.CustomerRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    CustomerRepositoty customerRepositoty;
    public Customer createCustomer(Customer customer){
        String password = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(password);
        return customerRepositoty.save(customer);
    }
}
