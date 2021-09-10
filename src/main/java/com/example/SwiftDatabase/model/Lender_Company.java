package com.example.SwiftDatabase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Lender_Company")
public class Lender_Company {

    @Id
    @Column(name = "Lender_Company_ID")
    String Lender_Company_ID;

    @Column(name = "Lender_Company")
    String Lender_Company;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getLender_Company_ID() {
        return Lender_Company_ID;
    }

    public void setLender_Company_ID(String lender_Company_ID) {
        Lender_Company_ID = lender_Company_ID;
    }

    public String getLender_Company() {
        return Lender_Company;
    }

    public void setLender_Company(String lender_Company) {
        Lender_Company = lender_Company;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
