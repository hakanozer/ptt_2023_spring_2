package com.works.restcontrollers;

import com.works.entities.Customer;
import com.works.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerRestController {

    final CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody Customer customer, BindingResult result) {
        return customerService.register(customer, result);
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return customerService.list();
    }

    @GetMapping("/single/{stCid}")
    public ResponseEntity single(@PathVariable String stCid) {
        return customerService.single(stCid);
    }

    @PutMapping("/update")
    public ResponseEntity update( @Valid @RequestBody Customer customer ) {
        return customerService.update(customer);
    }

    @DeleteMapping("/delete/{stCid}")
    public ResponseEntity delete(@PathVariable String stCid) {
        return customerService.delete(stCid);
    }

}
