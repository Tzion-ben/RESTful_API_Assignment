package com.Tzion.Assignment.ControllersAndServices;

/**
 * Represent the service Search class for the following:
 * In addition to the CRUD operations, I will implement the following search operations:
 * a. Find a customer by name
 * b. Find customers living in a specific city
 * c. Find customers in a specific age group (e.g. age 21 to 30).
 * @author Tzion Beniaminov
 */
import com.Tzion.Assignment.DataModels.Customer;
import com.Tzion.Assignment.DataModels.CustomerDataManager_Not_Persistent;
import com.Tzion.Assignment.Exceptions.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CustomerSearchService {

    @Autowired
    private CustomerDataManager_Not_Persistent fakeTestDate;

    //will return a customer with a specific name if there is one
    public Customer searchByName(String name) {
        int id = fakeTestDate.getCustomerByName(name);
        if(id == -1)
        {throw new ApiRequestException("There is no such customer");}
        return fakeTestDate.getCustomerById(id);
    }

    //will return the customers that lives in a specific city
    public Collection<Customer> getCustomersByCity(String city) {
        Collection<Customer> inTheCity = fakeTestDate.getCustomersByCity(city);
        if(inTheCity.isEmpty())
        {throw new ApiRequestException("There is no customers in "+city);}
        return inTheCity;
    }

    //will return the customers in specific age range
    public Collection<Customer> getCustomersByAgeGroup(int startAge , int endAge) {
        Collection<Customer> inAgeRange = fakeTestDate.getCustomersByAgeGroup(startAge , endAge);
        if(inAgeRange.isEmpty())
        {throw new ApiRequestException("There is no customers in age group from "
                +startAge + " to "+ endAge);}
        return inAgeRange;
    }
}
