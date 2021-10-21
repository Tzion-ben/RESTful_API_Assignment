package com.Tzion.Assignment.ControllersAndServices;
/**
 * Represent the Controller Search class for the following:
 * In addition to the CRUD operations, I will implement the following search operations:
 * a. Find a customer by name
 * b. Find customers living in a specific city
 * c. Find customers in a specific age group (e.g. age 21 to 30).
 * @author Tzion Beniaminov
 */
import com.Tzion.Assignment.DataModels.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "api/Tzion/assignment/customers/search")
public class CustomerSearchController {

    private final CustomerSearchService customerSearchService;

    @Autowired
    public CustomerSearchController(CustomerSearchService customerSearchService) {
        this.customerSearchService = customerSearchService;
    }

    //will return a customer with a specific name if there is one
    @RequestMapping(value = "/name:={name}")
    public Customer searchByName(@PathVariable("name") String name){
        return customerSearchService.searchByName(name);
    }

    @RequestMapping(value = "/city:={city}")
    public Collection<Customer> getCustomerByCity(@PathVariable("city") String city){
        return customerSearchService.getCustomersByCity(city);
    }

    @RequestMapping(value = "/fromAge:={startAge}-TO-endAge:={endAge}")
    public Collection<Customer> getCustomerByCity(
            @PathVariable("startAge") int startAge ,
            @PathVariable("endAge") int endAge){
        return customerSearchService.getCustomersByAgeGroup(startAge , endAge);
    }
}
