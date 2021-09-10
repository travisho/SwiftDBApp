package com.example.SwiftDatabase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Lender")
public class Lender {

    @Id
    @Column(name = "Lender_ID")
    String Lender_ID;

    @Column(name = " Lender_Company_ID")
    String Lender_Company_ID;

    @Column(name = " Lender_First_Name")
    String Lender_First_Name;

    @Column(name = "Lender_Last_Name")
    String  Lender_Last_Name;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getLender_ID() {
        return Lender_ID;
    }

    public void setLender_ID(String lender_ID) {
        Lender_ID = lender_ID;
    }

    public String getLender_Company_ID() {
        return Lender_Company_ID;
    }

    public void setLender_Company_ID(String lender_Company_ID) {
        Lender_Company_ID = lender_Company_ID;
    }

    public String getLender_First_Name() {
        return Lender_First_Name;
    }

    public void setLender_First_Name(String lender_First_Name) {
        Lender_First_Name = lender_First_Name;
    }

    public String getLender_Last_Name() {
        return Lender_Last_Name;
    }

    public void setLender_Last_Name(String lender_Last_Name) {
        Lender_Last_Name = lender_Last_Name;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
