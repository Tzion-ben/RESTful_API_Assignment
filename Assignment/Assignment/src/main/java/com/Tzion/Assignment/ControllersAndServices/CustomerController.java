package com.Tzion.Assignment.ControllersAndServices;

/**
 * Represent the Controller customers class for the following:
 * The basics CRUD operations: PUT,GET,DELETE,GET_ALL,POST
 * @author Tzion Beniaminov
 */
import com.Tzion.Assignment.DataModels.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "api/Tzion/assignment/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //this method will get all customers , part of CRUD
    @GetMapping
    public Collection<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    //this method will GET a customer by his id, part of CRUD
    @GetMapping(value = "/{id}")
    public Customer getCustomerById(@PathVariable("id") int id){
        return customerService.getCustomerById(id);
    }

    //this method will DELETE a customer by his id, part of CRUD
    @DeleteMapping(value = "/{id}" )
    public void deleteCustomerById(@PathVariable("id") int id){
        customerService.deleteCustomerById(id);
    }

    //this method will UPDATE a customer by his id, part of CRUD
    @PutMapping(value = "/{id}")
    public void updateCustomer(@PathVariable("id") int id ,@RequestBody String inputToUpdate){
        customerService.updateCustomer(id , inputToUpdate);
    }

    //this method will POST a new customer
    @PostMapping
    public void postNewCustomer(@RequestBody String inputCustomer){
        customerService.postNewCustomer(inputCustomer);
    }
}
