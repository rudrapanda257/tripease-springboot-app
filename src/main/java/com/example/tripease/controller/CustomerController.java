package com.example.tripease.controller;

import com.example.tripease.Enum.Gender;
import com.example.tripease.dto.response.CustomerResponse;
import com.example.tripease.model.Customer;
import com.example.tripease.dto.request.CustomerRequest;
import com.example.tripease.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public CustomerResponse addCustomer(@RequestBody CustomerRequest customerRequest){
        return customerService.addCustomer(customerRequest);
    }

    @GetMapping("/get/customer-id/{id}")
    public CustomerResponse getCustomer(@PathVariable("id") int customerId){
        return customerService.getCustomer(customerId);
    }

    @GetMapping("/get/gender/{gender}")
    public List<CustomerResponse> getAllByGender(@PathVariable("gender") Gender gender){
        return customerService.getAllByGender(gender);
    }

    @GetMapping("/getByGender/{gender}/{age}")
    public List<CustomerResponse> getAllByGenderAndAge(@PathVariable("gender") Gender gender,
                                                      @PathVariable("age") int age){
        return customerService.getAllByGenderAndAge(gender, age);
    }

    @GetMapping("/getByAddress/{address}/{age}")
    public List<CustomerResponse> getAllByAddressAndAge(@PathVariable("address") String address,
                                                         @PathVariable("age") int age){
        return customerService.getAllByAddressAndAge(address, age);
    }

    @PutMapping("update/{id}")
    public Customer updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer){
          return customerService.updateCustomer(id,customer);
    }

    //Delete Customer
    @DeleteMapping("/delete/{id}")
    public CustomerResponse deleteCustomer(@PathVariable("id") int id){
        CustomerResponse customerResponse = customerService.getCustomer(id);
        customerService.deleteCustomer(id);
        return customerResponse;
    }



}
