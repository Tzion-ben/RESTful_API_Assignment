package com.Tzion.Assignment.DataModels;

/**
 * Represents the search input details, will help with thew search operations
 * @author Tzion Beniaminov
 */
public class SearchBody {
    private String name;
    private String city;
    private String ageGroup;

    public SearchBody() {}

    public SearchBody(String name, String city, String ageGroup) {
        this.name = name;
        this.city = city;
        this.ageGroup = ageGroup;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }
}
