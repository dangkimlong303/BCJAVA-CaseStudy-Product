package com.longdk.productstudycase.controller;

import com.longdk.productstudycase.model.Category;
import com.longdk.productstudycase.model.Product;
import com.longdk.productstudycase.service.CategoryService;
import com.longdk.productstudycase.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

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
    public ModelAndView showListProductForm(@PageableDefault(size = 3) Pageable pageable, @RequestParam("name")Optional<String> name){
        Page<Product> products;
        if (name.isPresent()){
            products = productService.findAllByCompanyContaining(pageable,name.get());
        }else {
            products = productService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("product/list");
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

    @GetMapping("product-edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("product/edit");
        Product product = productService.findById(id);
        modelAndView.addObject("product",product);
        return modelAndView;
    }
    @PostMapping("product-edit")
    public ModelAndView EditProduct(@ModelAttribute("product") Product product){
        productService.save(product);
        return new ModelAndView("product/edit","mess","Product edit success !!");
    }
    @GetMapping("product-delete/{id}")
    public ModelAndView showDeleteProductForm(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("product/delete");
        Product product = productService.findById(id);
        modelAndView.addObject("product",product);
        return modelAndView;
    }
    @PostMapping("product-delete")
    public String deleteProduct(@ModelAttribute("product")Product product){
        productService.remove(product.getId());
        return "redirect:product-list";
    }
}
