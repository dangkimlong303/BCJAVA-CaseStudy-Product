package com.longdk.productstudycase.repository;

import com.longdk.productstudycase.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category,Long> {
}
