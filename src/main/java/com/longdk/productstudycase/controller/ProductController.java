package com.longdk.productstudycase.controller;

import com.longdk.productstudycase.model.Category;
import com.longdk.productstudycase.model.Product;
import com.longdk.productstudycase.service.CategoryService;
import com.longdk.productstudycase.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("category")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping("product-list")
    public ModelAndView showListProductForm(){
        ModelAndView modelAndView = new ModelAndView("product/list");
        Iterable<Product> products = productService.findAll();
        modelAndView.addObject("products",products);
        return modelAndView;
    }

    @GetMapping("product-create")
    public ModelAndView showCreateProductForm(){
        ModelAndView modelAndView = new ModelAndView("product/create");
        modelAndView.addObject("product",new Product());
        return modelAndView;
    }

    @PostMapping("product-create")
    public ModelAndView CreateProduct(@ModelAttribute("product")Product product){
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("product/create");
        modelAndView.addObject("mess","Product create success!");
        return modelAndView;
    }
}
