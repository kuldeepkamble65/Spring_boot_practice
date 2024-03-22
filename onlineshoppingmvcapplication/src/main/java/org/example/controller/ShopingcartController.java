package org.example.controller;

import org.example.Dao.ProductDao;
import org.example.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShopingcartController {

    @Autowired
    private ProductDao productDao;

    @RequestMapping("/")
    public String indexPage() {
        return "index";
    }
    @PostMapping(value = "/addproduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        productDao.addproduct(product);
        return ResponseEntity.ok("product added successfully !!!!");
    }
}
