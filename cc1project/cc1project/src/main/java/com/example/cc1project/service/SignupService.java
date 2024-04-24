package com.example.cc1project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.cc1project.model.Signup;
import com.example.cc1project.repository.SignupRepository;

@Service
public class SignupService {

   @Autowired
   public SignupRepository signupRepository;

   public Signup saveSignup(@RequestBody Signup signup)
   {
      return signupRepository.save(signup);
   }
    
   public Signup getSignupId(int id)
   {
      return signupRepository.findById(id).orElse(null);
   }

   public List<Signup> getAllList()
   {
     return signupRepository.findAll();
   }
   
   public void deleteData(int ids)
   {
      signupRepository.deleteById(ids);
   }
}
