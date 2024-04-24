package com.example.cc1project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cc1project.model.Cart;
import com.example.cc1project.service.CartService;


@RestController
@RequestMapping("/cart")
public class Cartontroller {

    @Autowired
    public CartService cartservice;

    @PostMapping("/post")
    public ResponseEntity<String> postProduct(@RequestBody Cart cartmodel) 
    {
        Cart c = cartservice.saveProduct(cartmodel);
        if( c!=null )
        {
           return new ResponseEntity<>("Your Food items saved in Cart",HttpStatus.CREATED); 
        }
        return new ResponseEntity<>("Your Food items Not Saved in Cart",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @GetMapping("/get/{productId}")
    public Cart getProductById(@PathVariable("productId") int id) 
    {
        return cartservice.gCartmodelid(id);
    }

    @GetMapping("/get")
    public List<Cart> getAllProducts() 
    {
        return cartservice.getCartmodels();
    }

    @PutMapping("/put/{productId}")
    public String updateProduct(@PathVariable("productId") int id, @RequestBody Cart updateCartmodel) 
    {
        Cart exProduct = cartservice.gCartmodelid(id);
        if (exProduct != null) 
        {
            exProduct.setProductName(updateCartmodel.getProductName());
            exProduct.setQuantity(updateCartmodel.getQuantity());
            exProduct.setPrice(updateCartmodel.getPrice());
            cartservice.saveProduct(exProduct);
        } 
        else 
        {
            return "No Data found to update";
        }
        return "Data updated successfully";
    }

    @DeleteMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable("productId") int id) 
    {
        Cart existProduct = cartservice.gCartmodelid(id);
        if (existProduct != null) 
        {
            cartservice.deleteData(id);
        } 
        else 
        {
            return "No Data found to delete";
        }
        return "Data deleted successfully";
    }
}
