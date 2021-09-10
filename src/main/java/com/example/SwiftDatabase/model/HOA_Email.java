package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HOA_Email")
public class HOA_Email {
    public String getHOA_Email_ID() {
        return HOA_Email_ID;
    }

    public void setHOA_Email_ID(String HOA_Email_ID) {
        this.HOA_Email_ID = HOA_Email_ID;
    }

    public String getHOA_ID() {
        return HOA_ID;
    }

    public void setHOA_ID(String HOA_ID) {
        this.HOA_ID = HOA_ID;
    }

    public String getHOA_Email() {
        return HOA_Email;
    }

    public void setHOA_Email(String HOA_Email) {
        this.HOA_Email = HOA_Email;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }

    @Id
    @Column(name = "HOA_Email_ID")
    String HOA_Email_ID;

    @Column(name = "HOA_ID")
    String HOA_ID;

    @Column(name = "HOA_Email")
    String HOA_Email;


    @Column(name = "isdelete")
    Boolean isdelete;


}
