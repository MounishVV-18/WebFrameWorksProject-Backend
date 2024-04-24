package com.example.cc1project.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cc1project.model.Payment;
import com.example.cc1project.repository.PaymentRepository;

@Service
public class PaymentService {
    @Autowired
    public PaymentRepository paymentRepo;

    public Payment savPayment(Payment payment)
    {
        return paymentRepo.save(payment);
    }
    public Payment getPaymentId(int id)
    {
        return paymentRepo.findById(id).orElse(null);
    }
    public List<Payment> getAllList()
    {
        return paymentRepo.findAll();
    }
    public void deleData(int id)
    {
        paymentRepo.deleteById(id);
    }
}
