package com.works.restcontrollers;

import com.works.entities.Customer;
import com.works.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerRestController {

    final CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody Customer customer, BindingResult result) {
        if (result.hasErrors() ) {
            return new ResponseEntity(result.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }
        customerService.register(customer);
        return new ResponseEntity(customer, HttpStatus.OK);
    }

}
