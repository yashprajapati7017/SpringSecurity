package com.springsecurity.testing.Server;

import org.springframework.stereotype.Service;

@Service
public class LogicServer {

    private int totalPrice;

    public int Per(int productPrice,int productDiscount){

        if(productDiscount<0||productDiscount>100){
            throw new IllegalArgumentException("Product discount must be between 0 and 100");
        }
        totalPrice=productPrice-(productPrice*productDiscount)/100;
        System.out.println("Total price: "+totalPrice);
        return  totalPrice;
    }
}
