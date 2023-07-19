package com.works.restcontrollers;

import com.works.entities.Product;
import com.works.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductRestController {

    final ProductService productService;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Product product) {
        return productService.add(product);
    }

    @PostMapping("/addAll")
    public ResponseEntity addAll(@RequestBody List<Product> products) {
        return productService.addAll(products);
    }

    @GetMapping("/list/{cid}")
    public ResponseEntity all(@PathVariable Long cid, @RequestParam(defaultValue = "0") int page) {
        return productService.all(cid, page);
    }

    @GetMapping("/search")
    public ResponseEntity search(
            @RequestParam(defaultValue = "") String title,
            @RequestParam(defaultValue = "0") int page
    ) {
        return productService.search(title, page);
    }

}
