package com.example.SwiftDatabase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Lender_Email")
public class Lender_Email {

    @Id
    @Column(name = "Lender_Email_ID")
    String Lender_Email_ID;

    @Column(name = " Lender_ID")
    String  Lender_ID;

    @Column(name = "Lender_Email")
    String Lender_Email;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getLender_Email_ID() {
        return Lender_Email_ID;
    }

    public void setLender_Email_ID(String lender_Email_ID) {
        Lender_Email_ID = lender_Email_ID;
    }

    public String getLender_ID() {
        return Lender_ID;
    }

    public void setLender_ID(String lender_ID) {
        Lender_ID = lender_ID;
    }

    public String getLender_Email() {
        return Lender_Email;
    }

    public void setLender_Email(String lender_Email) {
        Lender_Email = lender_Email;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
