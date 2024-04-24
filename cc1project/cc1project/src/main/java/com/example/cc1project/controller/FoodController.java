package com.example.cc1project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.cc1project.model.Food;
import com.example.cc1project.service.FoodService;

import java.util.*;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/fooditems")
public class FoodController {
    @Autowired
    public FoodService foodService;

    @PostMapping("/post")
    public ResponseEntity<String> postProduct(@RequestBody Food food) 
    {
        Food c = foodService.saveAvail(food);
        if( c!=null )
        {
           return new ResponseEntity<>("Food items saved",HttpStatus.CREATED); 
        }
        return new ResponseEntity<>("Food items Not Saved",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/post/{foodid}")
    public Food getID(@PathVariable("foodid") int a)
    {
        return foodService.getFoofId(a);
    }

    @GetMapping("/posts")
    public List<Food> getAll()
    {
        return foodService.getAllList();
    }

    @PutMapping("/put/{id}")
    public String updateName(@PathVariable("id") int id, @RequestBody Food updateFoodavail) 
    {
        Food exFoodAvail = foodService.getFoofId(id);
        if(exFoodAvail != null)
        {
            exFoodAvail.setFoodName(updateFoodavail.getFoodName());
            exFoodAvail.setFoodPrice(updateFoodavail.getFoodPrice());
            exFoodAvail.setFoodQuantity(updateFoodavail.getFoodQuantity());
            foodService.saveAvail(exFoodAvail);
        }
        else
        {
            return "Food item Not found to Update";
        }
        return "Food item Updated";
    }

    @DeleteMapping("/del/{foodID}")
    public String deleteName(@PathVariable("foodID") int id)
    {
        Food exFoodAvail = foodService.getFoofId(id);
        if(exFoodAvail != null)
        {
            foodService.deleData(id);
        }
        else
        {

            return "Food item Not deleted";
        }
        return "Food item deleted";
    }

    @GetMapping("/food/byprice")
    public ResponseEntity<List<String>> getFood(@RequestParam double price)
    {
         List<String> s = foodService.findPrice(price);
         if(s!=null)
         {
            return new ResponseEntity<>(s,HttpStatus.FOUND);
         }
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/pages/{pg}/{sz}/{field}")
    public List<Food> getsPage(@PathVariable("pg") int a,@PathVariable("sz") int b,@PathVariable("field") String c)
    {
        return foodService.getBypage(a, b, c);
    }
    
    
}