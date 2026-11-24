package com.springsecurity.testmock.Controller;

import com.springsecurity.testmock.Entity.ProductEntity;
import com.springsecurity.testmock.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    private ProductService productService;

    public MainController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public ResponseEntity<ProductEntity> getProductService(@RequestBody ProductEntity productEntity) {

        productService.save(productEntity);

        return ResponseEntity.ok(productEntity);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductEntity> get(@PathVariable int id) {

        ProductEntity responce= productService.findAll(id);

        return ResponseEntity.status(HttpStatus.FOUND).body(responce);

    }

}
