package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Homeowner_Associate")
public class Homeowner_Associate {
    @Id
    @Column(name = "HOA_ID")
    String HOA_ID;

    @Column(name = "Property_ID")
    String Property_ID;

    @Column(name = "HOA_First_Name")
    String HOA_First_Name;

    @Column(name = "HOA_Last_Name")
    String HOA_Last_Name;

    @Column(name = "HOA_Company")
    String HOA_Company;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getHOA_ID() {
        return HOA_ID;
    }

    public void setHOA_ID(String HOA_ID) {
        this.HOA_ID = HOA_ID;
    }

    public String getProperty_ID() {
        return Property_ID;
    }

    public void setProperty_ID(String property_ID) {
        Property_ID = property_ID;
    }

    public String getHOA_First_Name() {
        return HOA_First_Name;
    }

    public void setHOA_First_Name(String HOA_First_Name) {
        this.HOA_First_Name = HOA_First_Name;
    }

    public String getHOA_Last_Name() {
        return HOA_Last_Name;
    }

    public void setHOA_Last_Name(String HOA_Last_Name) {
        this.HOA_Last_Name = HOA_Last_Name;
    }

    public String getHOA_Company() {
        return HOA_Company;
    }

    public void setHOA_Company(String HOA_Company) {
        this.HOA_Company = HOA_Company;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
