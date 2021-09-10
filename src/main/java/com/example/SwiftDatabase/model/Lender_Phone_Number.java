package com.example.SwiftDatabase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Lender_Phone_Number")

public class Lender_Phone_Number {

    @Id
    @Column(name = "Lender_Phone_Number_ID")
    String Lender_Phone_Number_ID;

    @Column(name = "Lender_ID")
    String Lender_ID;

    @Column(name = "Lender_Phone_Number")
    String Lender_Phone_Number;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getLender_Phone_Number_ID() {
        return Lender_Phone_Number_ID;
    }

    public void setLender_Phone_Number_ID(String lender_Phone_Number_ID) {
        Lender_Phone_Number_ID = lender_Phone_Number_ID;
    }

    public String getLender_ID() {
        return Lender_ID;
    }

    public void setLender_ID(String lender_ID) {
        Lender_ID = lender_ID;
    }

    public String getLender_Phone_Number() {
        return Lender_Phone_Number;
    }

    public void setLender_Phone_Number(String lender_Phone_Number) {
        Lender_Phone_Number = lender_Phone_Number;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
