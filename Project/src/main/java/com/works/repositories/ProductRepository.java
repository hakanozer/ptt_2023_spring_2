package com.works.repositories;

import com.works.entities.Product;
import com.works.projections.IProCat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByTitleContainsIgnoreCase(String title, Pageable pageable);

    @Query(value = "select P.PID, PRICE, TITLE, C.CID, NAME from PUBLIC.PRODUCT as P inner join PUBLIC.PRODUCT_CATEGORIES PC on P.PID = PC.PRODUCT_PID inner join PUBLIC.CATEGORY C on C.CID = PC.CATEGORIES_CID where C.CID = ?1", nativeQuery = true)
    List<IProCat> joinPro( Long cid );



}