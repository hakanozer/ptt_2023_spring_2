package com.works.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

@lombok.Data
public class Product {
    private Long id;
    private String title;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String description;
    private Long price;
    private Double discountPercentage;
    private Double rating;
    private Long stock;
    private String brand;
    private String category;
    private String thumbnail;
    private List<String> images;
}
