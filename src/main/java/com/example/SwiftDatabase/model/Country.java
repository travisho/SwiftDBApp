package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Country")
public class Country {
    @Id
    @Column(name = "Country_ID")
    String Country_ID;

    @Column(name = "Country_Name")
    String Country_Name;

    public String getCountry_ID() {
        return Country_ID;
    }

    public void setCountry_ID(String country_ID) {
        Country_ID = country_ID;
    }

    public String getCountry_Name() {
        return Country_Name;
    }

    public void setCountry_Name(String country_Name) {
        Country_Name = country_Name;
    }
}
