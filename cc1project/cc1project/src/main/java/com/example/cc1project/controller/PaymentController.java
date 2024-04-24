package com.example.cc1project.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.cc1project.model.Payment;
import com.example.cc1project.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/pay")
public class PaymentController {
    @Autowired
    public PaymentService paymentService;

    @PostMapping("/post")
    public String getName(@RequestBody Payment payment) {
        paymentService.savPayment(payment);
        return "Payment Details Saved";
    }

    @GetMapping("/get/{paymentid}")
    public Payment getId(@PathVariable("paymentid") int a) 
    {
        return paymentService.getPaymentId(a);
    }

    @GetMapping("/posts")
    public List<Payment> getAlls()
    {
        return paymentService.getAllList();
    }
    
    
    @PutMapping("/put/{paymentid}")
    public String updateTable(@PathVariable("paymentid") int id, @RequestBody Payment updatePayment) 
    {
        Payment exPayment = paymentService.getPaymentId(id);
        if(exPayment != null)
        {
            exPayment.setPaymentId(updatePayment.getPaymentId());
            exPayment.setUserId(updatePayment.getUserId());
            exPayment.setPaymentMethod(updatePayment.getPaymentMethod());
            exPayment.setTotalAmount(updatePayment.getTotalAmount());
            paymentService.savPayment(exPayment);
        }
        else{
            return "No data found";
        }
        return "Data's updated";
    }

    @DeleteMapping("/del/{paymentid}")
    public String deleteData(@PathVariable("paymentid") int id)
    {
        Payment exPayment = paymentService.getPaymentId(id);
        if(exPayment != null)
        {
            paymentService.deleData(id);
        }
        else
        {
            return "No data found to delete";
        }
        return "Data found and deleted";
    }
}
