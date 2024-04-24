package com.example.cc1project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.cc1project.model.Food;
import com.example.cc1project.repository.FoodRepository;

import java.util.*;

@Service
public class FoodService {
    @Autowired
    public FoodRepository foodRepo;
    
    public Food saveAvail(@RequestBody Food foodAvail)
    {
        return foodRepo.save(foodAvail);
    }
    public Food getFoofId(int id)
    {
        return foodRepo.findById(id).orElse(null);
    } 
    public List<Food> getAllList()
    {
        return foodRepo.findAll();
    }
    public void deleData(int id)
    {
        foodRepo.deleteById(id);
    }
    public List<String> findPrice(double a)
    {
        return foodRepo.findByFoodPrice(a);
    }

    public List<Food> getBypage(int pg,int sz,String sor)
    {
        Page<Food> p = foodRepo.findAll(PageRequest.of(pg, sz, Sort.by(sor)));
        return p.getContent();
    }
}

