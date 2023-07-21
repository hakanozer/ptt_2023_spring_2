package com.works.services;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.works.models.IProductModel;
import com.works.models.Product;
import com.works.utils.Rest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class DummyService {

    final RestTemplate rt1;
    final ObjectMapper objectMapper;

    public IProductModel allProduct() {
        String url = "https://dummyjson.com/products";
        IProductModel stData = rt1.getForObject(url, IProductModel.class);
        return stData;
    }

    public ResponseEntity addProduct() {
        Product product = new Product();
        product.setTitle("TV");
        product.setDescription("Desc");
        product.setPrice(30000L);

        String json = "";
        try {
            json = objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL).writeValueAsString(product);
        }catch (Exception ex) {}
        String url = "https://dummyjson.com/products/add";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity http = new HttpEntity(json, headers);

        ResponseEntity<Product> responseEntity = rt1.postForEntity(url, http, Product.class);
        return Rest.success( responseEntity.getBody() );

    }

}
