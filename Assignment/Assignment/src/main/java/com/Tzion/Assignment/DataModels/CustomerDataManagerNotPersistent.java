package com.Tzion.Assignment.DataModels;

/**
 * Represents a not persistent, using standard libraries data for testing
 * @author Tzion Beniaminov
 */
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


@Repository
public class CustomerDataManagerNotPersistent {

    private static HashMap<String , Customer> testData;

    static {
        testData = new HashMap<String , Customer>() {
            {
                //first customer
                put("123456789", new Customer(
                        "Moshe Coen",
                        "123456789",
                        new ContactInformation(
                                "moshe@notRealMail.com",
                                "052-5555555",
                                new Address(
                                        "Tel-Aviv",
                                        "3068907",
                                        "12",
                                        "1")),
                        LocalDate.of(1998, Month.APRIL ,5),
                        123948,
                        new CreditCardInformation(
                                234567812345678L,
                                123,
                                LocalDate.of(2026,Month.AUGUST,13))));
////////////////////////////////////////////////////////////////////////////////////////////////
                //second customer
                put("123412345", new Customer(
                        "Mira Hmeirov",
                        "123412345",
                        new ContactInformation(
                                "mira@notRealMail.com",
                                "052-5555534",
                                new Address(
                                        "Haifa",
                                        "3056129",
                                        "34",
                                        "11")),
                        LocalDate.of(1990, Month.APRIL ,9),
                        124599,
                        new CreditCardInformation(
                                1234123412341234L,
                                321,
                                LocalDate.of(2027,Month.FEBRUARY,19))));
////////////////////////////////////////////////////////////////////////////////////////////////
                //third customer
                put("123409876", new Customer(
                        "Hana Hanina",
                        "123409876",
                        new ContactInformation(
                                "hana@notRealMail.com",
                                "052-5152534",
                                new Address(
                                        "Afula",
                                        "3091429",
                                        "94",
                                        "3")),
                        LocalDate.of(2007, Month.APRIL ,24),
                        198799,
                        new CreditCardInformation(
                                1234019212341234L,
                                351,
                                LocalDate.of(2037,Month.FEBRUARY,3))));
////////////////////////////////////////////////////////////////////////////////////////////////
                //fourth customer
                put("718285129", new Customer(
                        "Peter Petrov",
                        "718285129",
                        new ContactInformation(
                                "peter@notRealMail.com",
                                "055-9372014",
                                new Address(
                                        "Hadera",
                                        "2691429",
                                        "53",
                                        "93")),
                        LocalDate.of(2006, Month.MARCH ,18),
                        198799,
                        new CreditCardInformation(
                                8720143829561234L,
                                451,
                                LocalDate.of(2087,Month.FEBRUARY,9))));
////////////////////////////////////////////////////////////////////////////////////////////////
                //fifth customer
                put("662135129", new Customer(
                        "Nicolay Pushkin",
                        "662135129",
                        new ContactInformation(
                                "nicolay@notRealMail.com",
                                "054-8223014",
                                new Address(
                                        "Moscow",
                                        "2911429",
                                        "133",
                                        "43")),
                        LocalDate.of(1890, Month.JUNE ,28),
                        198799,
                        new CreditCardInformation(
                                8988887629561234L,
                                419,
                                LocalDate.of(2097,Month.APRIL,13))));
////////////////////////////////////////////////////////////////////////////////////////////////
                //sixth customer
                put("488841648", new Customer(
                        "Nicolay Tolstoy",
                        "488841648",
                        new ContactInformation(
                                "nicolay@notRealMail.com",
                                "058-1113014",
                                new Address(
                                        "Moscow",
                                        "3333429",
                                        "6353",
                                        "473")),
                        LocalDate.of(1808, Month.JUNE ,18),
                        134799,
                        new CreditCardInformation(
                                8111187629561234L,
                                519,
                                LocalDate.of(2077,Month.SEPTEMBER,19))));
////////////////////////////////////////////////////////////////////////////////////////////////
            }
        };
    }

    //this method returns all the objects of the customers
    public Collection<Customer> getAllCustomers(){
        return this.testData.values();
    }

    //O(1) time | this method return a specific customer by his id
    public Customer getCustomerById(String id){
        if(!this.testData.containsKey(id)){return null;}
        return this.testData.get(id);
    }

    //O(1) | this method remove a specific customer by his id
    public void deleteCustomerById(String id){
        if(this.testData.containsKey(id)){this.testData.remove(id);}
    }

    //O(1) time | this method will POST a new customer
    public void postNewCustomer(Customer customer) {
        this.testData.put(customer.getId() , customer);
    }

    //O(1) time | this method will UPDATE a customer by his id, part of CRUD
    public void updateCustomer(Customer customer){
        this.testData.put(customer.getId() , customer);
    }

    //////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////Methods for Search Services/////////////////////////////

    //O(n) time| methods for Search Services, get customer by name,
    //if more then one customer with this name it will return his too
    public Collection<Customer> getCustomerByName(String name) {
        Collection<Customer> customer = new ArrayList<Customer>();
        for(Customer c : this.testData.values()){
            if(c.getName().equals(name)){customer.add(c);}
        }
        return customer;
    }

    //O(n) time| methods for Search Services, get all customers in a specific city
    public Collection<Customer> getCustomersByCity(String city) {
        Collection<Customer> inTheCity = new ArrayList<Customer>();
        for(Customer c : this.testData.values()){
            if(c.getContactInfo().getAddress().getCityName().equals(city)){
                inTheCity.add(c);
            }
        }
        return inTheCity;
    }

    //O(n) time| methods for Search Services, get all customers in a specific age range
    //using JAVA LocalDate object
    public Collection<Customer> getCustomersByAgeGroup(int startAge , int endAge) {
        Collection<Customer> inAgeRange = new ArrayList<Customer>();
        for(Customer c : this.testData.values()){
            int customerAge = Period.between(c.getDateOfBirth() , LocalDate.now()).getYears();
            if((customerAge >= startAge)&&(customerAge <= endAge)){
                inAgeRange.add(c);
            }
        }
        return inAgeRange;
    }
}
