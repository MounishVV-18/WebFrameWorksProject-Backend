package com.example.cc1project.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.cc1project.model.Signup;
import com.example.cc1project.service.SignupService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/sign")
public class SignupController {
    
    @Autowired
    public SignupService signupService;

    @PostMapping("/post")
    public ResponseEntity<String> postProduct(@RequestBody Signup signup) 
    {
        Signup c =signupService.saveSignup(signup); 
        if( c!=null )
        {
           return new ResponseEntity<>("Food items saved",HttpStatus.CREATED); 
        }
        return new ResponseEntity<>("Food items Not Saved",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @GetMapping("/post/{signupid}")
    public Signup getId(@PathVariable("signupid") int a) 
    {
        return signupService.getSignupId(a);
    }
    
    @GetMapping("/posts")
    public List<Signup> getAll() 
    {
        return signupService.getAllList();
    }
    
    @PutMapping("/put/{signUpid}")
    public String updateTable(@PathVariable("signUpid") int id, @RequestBody Signup updateSignup)
    {
         Signup exSignup=signupService.getSignupId(id);    
         if(exSignup != null)
         {
            exSignup.setUserName(updateSignup.getUserName());
            exSignup.setMobileNo(updateSignup.getMobileNo());
            exSignup.setPassWord(updateSignup.getPassWord());
            exSignup.setEmail(updateSignup.getPassWord());
            signupService.saveSignup(exSignup);
         }
         else
         {
            return "User Data's Not Found To Update";
         }
         return "User's Data Updated";
    }

    @DeleteMapping("/del/{signid}")
    public String deleteData(@PathVariable("signid") int id)
    {
        Signup exsistSignup = signupService.getSignupId(id);
        if(exsistSignup != null)
        {
            signupService.deleteData(id);
        }
        else
        {
            return "User Data Not found to Delete";
        }
        return "User Data Found and Deleted";
    }
}
