package com.Tzion.Assignment.DataModels;

/**
 * Represents the customers address
 * @author Tzion Beniaminov
 */
public class Address {
    private String cityName;
    private String zipCode;
    private String houseNum;
    private String apartmentNum;


    public Address (){}

    public Address(String cityName,
                   String zipCode,
                   String houseNum,
                   String apartmentNum) {
        this.cityName = cityName;
        this.zipCode = zipCode;
        this.houseNum = houseNum;
        this.apartmentNum = apartmentNum;
    }

    public String getCityName() {
        return cityName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public String getApartmentNum() {
        return apartmentNum;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public void setApartmentNum(String apartmentNum) {
        this.apartmentNum = apartmentNum;
    }

    @Override
    public String toString() {
        return "Address{" +
                "cityName='" + cityName + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", houseNum='" + houseNum + '\'' +
                ", apartmentNum='" + apartmentNum + '\'' +
                '}';
    }
}