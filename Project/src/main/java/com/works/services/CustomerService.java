package com.works.services;

import com.works.entities.Customer;
import com.works.repositories.CustomerRepository;
import com.works.utils.Rest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    final CustomerRepository customerRepository;

    public ResponseEntity register(Customer customer, BindingResult result ) {
        if (result.hasErrors() ) {
            return Rest.fail(result.getFieldErrors(),HttpStatus.BAD_REQUEST );
        }
        try {
            customerRepository.save(customer);
            return Rest.success(customer);
        }catch (Exception ex) {
            return Rest.fail("Unique index or primary key email",HttpStatus.BAD_REQUEST );
        }
    }

    public ResponseEntity list() {
        List<Customer> customerList = customerRepository.findAll();
        return Rest.success(customerList);
    }


}
