package com.works.services;

import com.works.entities.Customer;
import com.works.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    final CustomerRepository customerRepository;

    public Customer register( Customer customer ) {
        try {
            customerRepository.save(customer);
            return customer;
        }catch (Exception ex) {

        }

    }

}
