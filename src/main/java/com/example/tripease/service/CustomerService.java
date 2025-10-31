package com.example.tripease.service;

import com.example.tripease.Enum.Gender;
import com.example.tripease.dto.request.CustomerRequest;
import com.example.tripease.dto.response.CustomerResponse;
import com.example.tripease.exception.CustomerNotFoundException;
import com.example.tripease.model.Customer;
import com.example.tripease.repository.CustomerRepository;
import com.example.tripease.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    //Add a customer in database
    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
       // RequestDTO -> Entity.
        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);

        //save the entity to DB
        Customer saveCustomer = customerRepository.save(customer);

        //saved entity(which return by save()) -> Response DTO
        return CustomerTransformer.customerToCustomerResponse(saveCustomer);
    }

    //get customer from mDB
    public CustomerResponse getCustomer(int customerId) {

        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);   // developer declar findById as optional<> return type.
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Invalid customert id");
        }

        //saved response -> DTO
       return CustomerTransformer.customerToCustomerResponse(optionalCustomer.get());
    }

    //Get Gender from DB
    public List<CustomerResponse> getAllByGender(Gender gender) {
       List<Customer> customers = customerRepository.findByGender(gender);

       List<CustomerResponse> list = new ArrayList<>();
       for(Customer customer : customers){
           list.add( CustomerTransformer.customerToCustomerResponse(customer));
       }

       return list;
    }

    //get Gender & Age list from DB
    public List<CustomerResponse> getAllByGenderAndAge(Gender gender, int age) {
        List<Customer> customers = customerRepository.findByGenderAndAge(gender,age);

        List<CustomerResponse> list = new ArrayList<>();
        for(Customer customer : customers){
            list.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return list;
    }

    // Get address & Age list from DB
    public List<CustomerResponse> getAllByAddressAndAge(String address, int age) {
        List<Customer> customers = customerRepository.getAllByAddressAndAge(address,age);

        List<CustomerResponse> list = new ArrayList<>();
        for(Customer customer : customers){
            list.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return list;
    }

    //Update customer
    public Customer updateCustomer(int id, Customer customer){
        Customer oldCustomer = customerRepository.findById(id).orElse(null);
        if(Objects.nonNull(oldCustomer)){
            oldCustomer.setName(customer.getName());
            oldCustomer.setGender(customer.getGender());
            oldCustomer.setEmailId(customer.getEmailId());
            oldCustomer.setAge(customer.getAge());
            oldCustomer.setAddress(customer.getAddress());
            return customerRepository.save(oldCustomer);
        }
        return oldCustomer;

    }

    //detete Customer
    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }
}
