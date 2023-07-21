package com.works.restcontrollers;

import com.works.models.IProductModel;
import com.works.services.DummyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dummy")
public class DummyRestController {

    final DummyService dummyService;

    @GetMapping("/all")
    public IProductModel all() {
        return dummyService.allProduct();
    }

    @PostMapping("/add")
    public ResponseEntity add() {
       return dummyService.addProduct();
    }

}
