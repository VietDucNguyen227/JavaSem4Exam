package com.example.javaexamsem4.controller;

import com.example.javaexamsem4.model.Product;
import com.example.javaexamsem4.repository.ProductRepository;
import com.example.javaexamsem4.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/createProduct")
    private String createProduct(@ModelAttribute Product product){
        try {
            productService.createProduct(product);
            return "redirect:/listProduct";
        }catch (Exception ex){
            System.out.println("createProduct error with: "+ex);
        }
        return null;
    }

    @GetMapping("/addProduct")
    public String addEmployee(Model model){
        Product newProduct = new Product();
        model.addAttribute("product",newProduct);
        return "addProduct";
    }

    @GetMapping(value = {"/listProduct","/"})
    public String findAllEmployees(Model model){
        try {
            List<Product> products = productService.findAllProduct();
            model.addAttribute("products",products);
            return "listProduct";
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
