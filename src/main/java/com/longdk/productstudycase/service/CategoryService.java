package com.longdk.productstudycase.service;

import com.longdk.productstudycase.model.Category;

public interface CategoryService {
    Iterable<Category> findAll();

    Category findById(Long id);
}
