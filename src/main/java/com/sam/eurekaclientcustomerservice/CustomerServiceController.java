package com.sam.eurekaclientcustomerservice;


import com.sam.eurekaclientcustomerservice.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerServiceController {


    @GetMapping("/")
    public String home(){
        return "Eureka Client Application Running";
    }

    @GetMapping("/listcustomer/{id}")
    public Customer getCustomer(@PathVariable int id){
        List<Customer> customerList=new ArrayList<>();

        Customer customer=new Customer(1,"Morgan","Laptop");
        Customer customer1=new Customer(2,"Angela","Desktop");
        Customer customer2=new Customer(3,"Chris","MacBook Pro");
        Customer customer3=new Customer(4,"Matthew","iPad");

        customerList.add(customer);
        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);

        for(Customer c:customerList){
            if(c.getId()==id){
                return c;

            }
        }
        return null;
    }

    @GetMapping("/allcustomers")
    public List<Customer> getCustomerList(){
        List<Customer> customerList=new ArrayList<>();
        Customer customer=new Customer(1,"Morgan","Laptop");
        Customer customer1=new Customer(2,"Angela","Desktop");
        Customer customer2=new Customer(3,"Chris","MacBook Pro");
        Customer customer3=new Customer(4,"Matthew","iPad");

        customerList.add(customer);
        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);

        return customerList;

    }

    @GetMapping("/addcustomer/{id}")
    public String addCustomer(@PathVariable int id){
        Customer newCustomer=new Customer(id,"Lisa","Unix License");
        return "New customer added"+newCustomer.toString();
    }
}
