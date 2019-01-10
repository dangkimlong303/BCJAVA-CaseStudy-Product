package com.longdk.productstudycase.service;

import com.longdk.productstudycase.model.Product;

public interface ProductService {
    Iterable<Product> findAll();

    Product findById(Long id);

    void save(Product product);

    void remove(Long id);
}
