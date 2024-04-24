package com.example.cc1project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cc1project.model.Cart;
import com.example.cc1project.repository.CartRepository;



@Service
public class CartService {

    @Autowired
    public CartRepository repo;

    public Cart saveProduct(Cart cartmodel) {
        return repo.save(cartmodel);
    }

    public List<Cart> getCartmodels() {
        return repo.findAll();
    }

    public Cart gCartmodelid(int id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteData(int id) {
        repo.deleteById(id);
    }
}
