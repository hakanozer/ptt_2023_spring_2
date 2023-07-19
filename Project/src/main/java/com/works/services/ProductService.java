package com.works.services;

import com.works.entities.Product;
import com.works.projections.IProCat;
import com.works.repositories.ProductRepository;
import com.works.utils.Rest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository productRepository;

    public ResponseEntity add(Product product) {
        productRepository.save(product);
        return Rest.success(product);
    }

    public ResponseEntity addAll(List<Product> products) {
        productRepository.saveAll(products);
        return Rest.success(products);
    }

    public ResponseEntity all(Long cid) {
        List<IProCat> list = productRepository.joinPro(cid);
        return Rest.success(list);
    }

    public ResponseEntity search( String title, int page ) {
        Sort sort = Sort.by("price").descending();
        Pageable pageable = PageRequest.of(page, 10, sort);
        Page<Product> productList = productRepository.findByTitleContainsIgnoreCase(title, pageable);
        return Rest.success(productList);
    }


}