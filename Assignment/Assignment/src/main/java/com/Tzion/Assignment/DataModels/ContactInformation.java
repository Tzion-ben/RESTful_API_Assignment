package com.Tzion.Assignment.DataModels;

/**
 * Represents the customers personal contact information
 * @author Tzion Beniaminov
 */
public class ContactInformation {

    private String email;
    private String phoneNumber;
    private Address address;

    public ContactInformation(){}

    public ContactInformation(String email,
                              String phoneNumber,
                              Address address) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ContactInformation{" +
                "email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address=" + address +
                '}';
    }
}
