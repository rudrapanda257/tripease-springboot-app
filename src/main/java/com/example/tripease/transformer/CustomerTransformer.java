package com.example.tripease.transformer;

import com.example.tripease.dto.request.CustomerRequest;
import com.example.tripease.dto.response.CustomerResponse;
import com.example.tripease.model.Customer;

public class CustomerTransformer {
    //CustomerRequest -> Customer
    public static Customer customerRequestToCustomer(CustomerRequest customerRequest){
//        Customer customer = new Customer();
//        customer.setName(customerRequest.getName());
//        customer.setAge(customerRequest.getAge());
//        customer.setEmailId(customerRequest.getEmailId());
//        customer.setGender(customerRequest.getGender());
//        customer.setAddress(customerRequest.getAddress());
//        return  customer;
        Customer customer = Customer.builder()
                            .name(customerRequest.getName())
                            .age(customerRequest.getAge())
                            .emailId(customerRequest.getEmailId())
                            .gender(customerRequest.getGender())
                            .address(customerRequest.getAddress())
                            .build();
        return customer;
    }

    //Customer -> CustomerResponse
    public static CustomerResponse customerToCustomerResponse(Customer customer){
//        CustomerResponse customerResponse = new CustomerResponse();
//        customerResponse.setName(customer.getName());
//        customerResponse.setAge(customer.getAge());
//        customerResponse.setEmailId(customer.getEmailId());
//        return customerResponse;

        CustomerResponse customerResponse = CustomerResponse.builder()
                                           .name(customer.getName())
                                           .age(customer.getAge())
                                           .emailId(customer.getEmailId())
                                           .build();
        return customerResponse;
    }


}
