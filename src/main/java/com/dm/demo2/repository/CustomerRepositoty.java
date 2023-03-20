package com.dm.demo2.repository;
import com.dm.demo2.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface CustomerRepositoty extends CrudRepository<Customer, Integer> {

    List<Customer> findByUsername(String username);
}
