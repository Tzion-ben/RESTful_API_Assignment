package com.Tzion.Assignment.ControllersAndServices;

/**
 * Represent the service customers class for the following:
 * The basics CRUD operations: PUT,GET,DELETE,GET_ALL,POST
 * @author Tzion Beniaminov
 */
import com.Tzion.Assignment.DataModels.Customer;
import com.Tzion.Assignment.DataModels.CustomerDataManager_Not_Persistent;
import com.Tzion.Assignment.Exceptions.ApiRequestException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Collection;
import java.util.Set;

@Service
public class CustomerService {

    @Autowired
    private CustomerDataManager_Not_Persistent fakeTestDate;

    //returns all the objects of the customers
    public Collection<Customer> getAllCustomers(){
        if(fakeTestDate.getAllCustomers().isEmpty())
        {throw new ApiRequestException("There is no Have a customers");}

        return fakeTestDate.getAllCustomers();
    }

    //return a specific customer by his id
    public Customer getCustomerById(int id){
        if(fakeTestDate.getCustomerById(id) == null)
        {throw new ApiRequestException("There is no such customer");}
        return fakeTestDate.getCustomerById(id);
    }

    //remove a specific customer by his id
    public void deleteCustomerById(int id){
        if(fakeTestDate.getCustomerById(id) == null)
        {throw new ApiRequestException("There is no such customer");}
        fakeTestDate.deleteCustomerById(id);
    }


    //this method will POST a new customer
    public void postNewCustomer(String inputCustomer) {
        Customer customer = updateORpost(inputCustomer);

        //need to check if the customer is already exist
        if(fakeTestDate.getCustomerById(customer.getId()) != null)
        {throw new ApiRequestException("This customer already exist");}

        fakeTestDate.postNewCustomer(customer);
    }


    //this method will UPDATE a customer by his id, part of CRUD
    public void updateCustomer(int id,String inputToUpdate){
        // if this customer not exist so can't update it
        if(fakeTestDate.getCustomerById(id) == null)
        {throw new ApiRequestException("This customer is not exist, can't update.");}

        Customer customer = updateORpost(inputToUpdate);
        fakeTestDate.updateCustomer(customer);
    }


    //this method will validate the input JSON for create a new customer or to updating
    //existing one
    private Customer updateORpost (String inputCustomer){
        //will validate the input JSON by the customer.schema.json file
        InputStream inputStream = Customer.class.getClassLoader().getResourceAsStream("model/customer.schema.json");
        JsonSchema jsonSchema = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7).getSchema(inputStream);

        //an object to read the JSON
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        JsonNode jsonNode;
        try {
            jsonNode = objectMapper.readTree(inputCustomer);
        } catch (JsonProcessingException e) {
            throw new ApiRequestException("JSON is incorrect, please fix it :)");
        }

        Set<ValidationMessage> errors = jsonSchema.validate(jsonNode);
        StringBuilder errorMessage = new StringBuilder();
        for(ValidationMessage error : errors){errorMessage.append(error.toString());}

        //throw a string that represent the missing properties in the JSON input string
        if(errors.size() > 0){throw new ApiRequestException(errorMessage.toString());}

        Customer customer;
        try {
            customer = objectMapper.readValue(jsonNode.toString() , Customer.class);
        } catch (JsonProcessingException e) {
            throw new ApiRequestException("Cannot read the JSON file");
        }

        return customer;
    }
}
