package com.example.cc1project.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String productName;
    private int quantity;
    private int price;

    @OneToOne(cascade = CascadeType.REMOVE,mappedBy = "cart")
    private Payment payment;

    @OneToOne
    @JsonBackReference
    private Signup signup;


    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "cart1")
    private List<Food> food;
}

