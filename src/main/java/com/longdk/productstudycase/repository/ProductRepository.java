package com.longdk.productstudycase.repository;

import com.longdk.productstudycase.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {

}
