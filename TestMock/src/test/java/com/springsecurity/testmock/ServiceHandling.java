package com.springsecurity.testmock;

import com.springsecurity.testmock.Entity.ProductEntity;
import com.springsecurity.testmock.Repository.ProductRepo;
import com.springsecurity.testmock.Service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServiceHandling {

    @Mock
    private ProductRepo productRepo;
    @InjectMocks
    private ProductService productService;

    @Test
    public void shouldProductExist(){
        ProductEntity productEntity = new ProductEntity(1,"Laptop",50000.00,20.00);

        when(productRepo.findById(1)).thenReturn(Optional.of(productEntity));

        ProductEntity actualProduct= productService.findAll(1);

        assertEquals(1,actualProduct.getId());
        assertEquals("Laptop",actualProduct.getName());

        verify(productRepo).findById(1);
    }

    @Test
    public void shouldCheckProductExist(){

        when(productRepo.findById(99)).thenReturn(Optional.empty());

        RuntimeException runtimeException= assertThrows
                (RuntimeException.class, ()->productService.findAll(99));

        assertEquals("Product not found",runtimeException.getMessage());
    }

}
