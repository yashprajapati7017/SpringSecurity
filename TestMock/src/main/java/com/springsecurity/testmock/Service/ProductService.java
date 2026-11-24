package com.springsecurity.testmock.Service;

import com.springsecurity.testmock.Entity.ProductEntity;
import com.springsecurity.testmock.Repository.ProductRepo;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public ProductEntity save(ProductEntity productEntity) {
        return productRepo.save(productEntity);
    }

    public ProductEntity findAll(int id) {
        ProductEntity result= productRepo.findById(id).orElseThrow(
                ()->new RuntimeException("Product not found"));

        return result;
    }

}
