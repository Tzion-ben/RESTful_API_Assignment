package com.Tzion.Assignment.ControllersAndServices;

/**
 * Represent the Controller customers class for the following:
 * The basics CRUD operations: PUT,GET,DELETE,GET_ALL,POST
 * @author Tzion Beniaminov
 */
import com.Tzion.Assignment.DataModels.Customer;
import com.Tzion.Assignment.DataModels.SearchBody;
import com.Tzion.Assignment.Exceptions.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "api/customers")
public class CustomerController {

    private  CustomerService customerService;

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
    public Customer getCustomerById(@PathVariable("id") String id){
        return customerService.getCustomerById(id);
    }

    //this method will DELETE a customer by his id, part of CRUD
    @DeleteMapping(value = "/{id}" )
    public void deleteCustomerById(@PathVariable("id") String id){
        customerService.deleteCustomerById(id);
    }

    //this method will UPDATE a customer by his id, part of CRUD
    @PutMapping(value = "/{id}")
    public void updateCustomer(@PathVariable("id") String id ,@RequestBody Customer inputToUpdate){
        customerService.updateCustomer(id , inputToUpdate);
    }

    //this method will POST a new customer, part of CRUD
    @PostMapping(consumes = "application/json", produces = "application/json")
    public void postNewCustomer(@RequestBody Customer inputCustomer){
        customerService.postNewCustomer(inputCustomer);
    }

    @PostMapping(value = "/search")
    public List<Customer> search(@RequestBody SearchBody body){
        if(body.getName() != null && body.getCity()!=null && body.getAgeGroup() != null){
            List<Customer> ans = customerService.searchByName(body.getName());
            customerService.getCustomersByCity(ans , body.getCity());
            customerService.getCustomersByAgeGroup(ans , body.getAgeGroup());

            return ans;
        }

        throw new ApiRequestException("There is missing properties");
    }
}