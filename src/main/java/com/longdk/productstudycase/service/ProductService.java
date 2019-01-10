package com.longdk.productstudycase.service;

import com.longdk.productstudycase.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);

    Product findById(Long id);

    void save(Product product);

    void remove(Long id);

    Page<Product> findAllByCompanyContaining(Pageable pageable,String name);
}
