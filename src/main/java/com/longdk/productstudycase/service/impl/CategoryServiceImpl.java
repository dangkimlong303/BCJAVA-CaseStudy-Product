package com.longdk.productstudycase.service.impl;

import com.longdk.productstudycase.model.Category;
import com.longdk.productstudycase.repository.CategoryRepository;
import com.longdk.productstudycase.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).get();
    }
}
