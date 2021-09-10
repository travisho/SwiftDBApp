package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Property")
public class Property {
    @Id
    @Column(name = "Property_ID")
    String Property_ID;

    @Column(name = "Home_Builder_ID")
    String Home_Builder_ID;

    @Column(name = "Property_Style_ID")
    String Property_Style_ID;

    @Column(name = "Street_Address")
    String Street_Address;

    @Column(name = "City")
    String City;

    @Column(name = "State_ID")
    String State_ID;

    @Column(name = "Zip_Code")
    String Zip_Code;

    @Column(name = "Country_ID")
    String Country_ID;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getProperty_ID() {
        return Property_ID;
    }

    public void setProperty_ID(String property_ID) {
        Property_ID = property_ID;
    }

    public String getHome_Builder_ID() {
        return Home_Builder_ID;
    }

    public void setHome_Builder_ID(String home_Builder_ID) {
        Home_Builder_ID = home_Builder_ID;
    }

    public String getProperty_Style_ID() {
        return Property_Style_ID;
    }

    public void setProperty_Style_ID(String property_Style_ID) {
        Property_Style_ID = property_Style_ID;
    }

    public String getStreet_Address() {
        return Street_Address;
    }

    public void setStreet_Address(String street_Address) {
        Street_Address = street_Address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState_ID() {
        return State_ID;
    }

    public void setState_ID(String state_ID) {
        State_ID = state_ID;
    }

    public String getZip_Code() {
        return Zip_Code;
    }

    public void setZip_Code(String zip_Code) {
        Zip_Code = zip_Code;
    }

    public String getCountry_ID() {
        return Country_ID;
    }

    public void setCountry_ID(String country_ID) {
        Country_ID = country_ID;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
