package com.longdk.productstudycase;

import com.longdk.productstudycase.service.CategoryService;
import com.longdk.productstudycase.service.ProductService;
import com.longdk.productstudycase.service.impl.CategoryServiceImpl;
import com.longdk.productstudycase.service.impl.ProductServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductStudycaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductStudycaseApplication.class, args);
	}

	@Bean
	public ProductService productService(){
		return new ProductServiceImpl();
	}
	@Bean
	public CategoryService categoryService(){
		return new CategoryServiceImpl();
	}
}

