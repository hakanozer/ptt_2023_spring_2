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
import java.util.Optional;

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

    public ResponseEntity single( String stCid ) {
        try {
            long cid = Long.parseLong(stCid);
            Optional<Customer> optionalCustomer = customerRepository.findById(cid);
            if (optionalCustomer.isPresent()) {
                return Rest.success( optionalCustomer.get() );
            }else {
                return Rest.fail("Customer Not Found!", HttpStatus.BAD_REQUEST);
            }
        }catch (Exception ex) {
            return Rest.fail(ex.getStackTrace()[0].getClassName() + " " + ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    public ResponseEntity update( Customer customer ) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customer.getCid());
        if (optionalCustomer.isPresent()) {
            try {
                customerRepository.saveAndFlush(customer);
                return Rest.success(customer);
            }catch (Exception ex) {
                return Rest.fail("Unique index or primary key email",HttpStatus.BAD_REQUEST );
            }
        }else {
            return Rest.fail(customer.getCid() + ", Not Found", HttpStatus.BAD_REQUEST);
        }
    }


    public ResponseEntity delete( String stCid ) {
        try {
            long cid = Long.parseLong(stCid);
            Optional<Customer> optionalCustomer = customerRepository.findById(cid);
            if (optionalCustomer.isPresent()) {
                customerRepository.deleteById(cid);
                return Rest.success( optionalCustomer.get() );
            }else {
                return Rest.fail(stCid + " Customer Not Found!", HttpStatus.BAD_REQUEST);
            }
        }catch (Exception ex) {
            return Rest.fail(ex.getStackTrace()[0].getClassName() + " " + ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
