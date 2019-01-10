package com.longdk.productstudycase.service.impl;

import com.longdk.productstudycase.model.Product;
import com.longdk.productstudycase.repository.ProductRepository;
import com.longdk.productstudycase.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> findAllByCompanyContaining(Pageable pageable, String name) {
        return productRepository.findAllByCompanyContaining(pageable,name);
    }
}
