package com.Tzion.Assignment.DataModels;

/**
 * Represents the customers details
 * @author Tzion Beniaminov
 */
import java.time.LocalDate;


public class Customer {
    private String name;
    private int id;
    private ContactInformation contactInfo;
    private LocalDate dateOfBirth;
    private int DLnum; // Abbreviation for Driver License Number
    private CreditCardInformation creditCardInfo;

    public Customer() {}

    public Customer(String name,
                    int id,
                    ContactInformation contactInfo,
                    LocalDate dateOfBirth,
                    int DLnum,
                    CreditCardInformation creditCardInfo) {
        this.name = name;
        this.id = id;
        this.contactInfo = contactInfo;
        this.dateOfBirth = dateOfBirth;
        this.DLnum = DLnum;
        this.creditCardInfo = creditCardInfo;
    }

    public Customer(String name,
                    ContactInformation contactInfo,
                    LocalDate dateOfBirth,
                    int DLnum,
                    CreditCardInformation creditCardInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.dateOfBirth = dateOfBirth;
        this.DLnum = DLnum;
        this.creditCardInfo = creditCardInfo;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public ContactInformation getContactInfo() {
        return contactInfo;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getDLnum() {
        return DLnum;
    }

    public CreditCardInformation getCreditCardInfo() {
        return creditCardInfo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContactInfo(ContactInformation contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDLnum(int DLnum) {
        this.DLnum = DLnum;
    }

    public void setCreditCardInfo(CreditCardInformation creditCardInfo) {
        this.creditCardInfo = creditCardInfo;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", contactInfo=" + contactInfo +
                ", dateOfBirth=" + dateOfBirth +
                ", DLnum=" + DLnum +
                ", creditCardInfo=" + creditCardInfo +
                '}';
    }
}
