package com.Tzion.Assignment.ControllersAndServices;

/**
 * Represent the service customers class for the following:
 * The basics CRUD operations: PUT,GET,DELETE,GET_ALL,POST
 * @author Tzion Beniaminov
 */
import com.Tzion.Assignment.DataModels.Customer;
import com.Tzion.Assignment.DataModels.CustomerDataManagerNotPersistent;
import com.Tzion.Assignment.Exceptions.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class CustomerService {

    @Autowired
    private CustomerDataManagerNotPersistent dataManagment;

    //returns all the objects of the customers
    public Collection<Customer> getAllCustomers(){
        if(dataManagment.getAllCustomers().isEmpty())
        {throw new ApiRequestException("There is no Have a customers");}

        return dataManagment.getAllCustomers();
    }

    //return a specific customer by his id
    public Customer getCustomerById(String id){
        if(dataManagment.getCustomerById(id) == null)
        {throw new ApiRequestException("There is no such customer");}
        return dataManagment.getCustomerById(id);
    }

    //remove a specific customer by his id
    public void deleteCustomerById(String id){
        if(dataManagment.getCustomerById(id) == null)
        {throw new ApiRequestException("There is no such customer");}
        dataManagment.deleteCustomerById(id);
    }


    //this method will POST a new customer
    public void postNewCustomer(Customer inputCustomer) {
        if(inputCustomer == null){
            throw new ApiRequestException("Id is missing");
        }
        //need to check if the customer is already exist or the id is missing
        if(inputCustomer.getId() == null) {throw new ApiRequestException("Id is missing");}
        if(dataManagment.getCustomerById(inputCustomer.getId()) != null)
        {throw new ApiRequestException("This customer already exist");}

        dataManagment.postNewCustomer(inputCustomer);
    }


    //this method will UPDATE a customer by his id, part of CRUD
    public void updateCustomer(String id,Customer inputToUpdate){
        // if this customer not exist so can't update it
        if(dataManagment.getCustomerById(id) == null)
        {throw new ApiRequestException("This customer is not exist, can't update.");}

        dataManagment.updateCustomer(inputToUpdate);
    }

    /////////////////////////////////////////////////////////////////////////
    /**
     * In addition to the CRUD operations, I will implement the following search operations:
     * a. Find a customer by name
     * b. Find customers living in a specific city
     * c. Find customers in a specific age group (e.g. age 21 to 30).
     */
    //will return a customer with a specific name if there is one
    public Collection<Customer> searchByName(String name) {
        Collection<Customer> specificName =  dataManagment.getCustomerByName(name);
        if(specificName == null)
        {throw new ApiRequestException("There is no such customer");}
        return specificName;
    }

    //will return the customers that lives in a specific city
    public Collection<Customer> getCustomersByCity(String city) {
        Collection<Customer> inTheCity = dataManagment.getCustomersByCity(city);
        if(inTheCity.isEmpty())
        {throw new ApiRequestException("There is no customers in "+city);}
        return inTheCity;
    }

    //will return the customers in specific age range
    public Collection<Customer> getCustomersByAgeGroup(String ages) {
        String [] agesRange = ages.split(" ");
        int startAge = 0;
        int endAge = 0;
        try {
            startAge = Integer.valueOf(agesRange[0]);
            endAge = Integer.valueOf(agesRange[2]);
        }catch (Exception e){
            throw new ApiRequestException("The range isn't correct");
        }
        Collection<Customer> inAgeRange = dataManagment.getCustomersByAgeGroup(startAge , endAge);
        if(inAgeRange.isEmpty())
        {throw new ApiRequestException("There is no customers in age group from "
                +startAge + " to "+ endAge);}
        return inAgeRange;
    }
}
