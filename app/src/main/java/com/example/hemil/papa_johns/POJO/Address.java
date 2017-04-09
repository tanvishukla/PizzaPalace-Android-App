package com.example.hemil.papa_johns.POJO;

/**
 * Created by hemil on 11/24/2015.
 */
public class Address {

    private String streetName;
    private String aptNum;
    private String city;
    private String zipCode;
    private String state;

    public Address(){}

    public Address(String streetName, String aptNum, String city, String zipCode, String state) {
        super();
        this.streetName = streetName;
        this.aptNum = aptNum;
        this.city = city;
        this.zipCode = zipCode;
        this.state = state;
    }
    public String getStreetName() {
        return streetName;
    }
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    public String getAptNum() {
        return aptNum;
    }
    public void setAptNum(String aptNum) {
        this.aptNum = aptNum;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

}
