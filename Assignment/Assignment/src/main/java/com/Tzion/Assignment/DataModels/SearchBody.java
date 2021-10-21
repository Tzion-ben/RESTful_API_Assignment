package com.Tzion.Assignment.DataModels;

/**
 * Represents the search input details, will help with thew search operations
 * @author Tzion Beniaminov
 */
public class SearchBody {
    private String name;
    private String city;
    private String startRangeAge_endRangeAge;

    public SearchBody() {}

    public SearchBody(String name, String city, String startRangeAge_endRangeAge) {
        this.name = name;
        this.city = city;
        this.startRangeAge_endRangeAge = startRangeAge_endRangeAge;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getStartRangeAge_endRangeAge() {
        return startRangeAge_endRangeAge;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStartRangeAge_endRangeAge(String startRangeAge_endRangeAge) {
        this.startRangeAge_endRangeAge = startRangeAge_endRangeAge;
    }
}
