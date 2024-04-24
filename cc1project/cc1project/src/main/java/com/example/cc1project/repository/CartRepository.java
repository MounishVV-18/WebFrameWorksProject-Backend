package com.example.cc1project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cc1project.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer>{

    
}
