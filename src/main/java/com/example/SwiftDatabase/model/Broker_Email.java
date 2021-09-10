package com.example.SwiftDatabase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Broker_Email")
public class Broker_Email {

    @Id
    @Column(name = "Broker_Email_ID")
    String Broker_Email_ID;

    @Column(name = "Broker_ID")
    String Broker_ID;

    @Column(name = "Broker_Email")
    String Broker_Email;

    @Column(name = "isdelete")
    Boolean isdelete;


    public String getBroker_Email_ID() {
        return Broker_Email_ID;
    }

    public void setBroker_Email_ID(String broker_Email_ID) {
        Broker_Email_ID = broker_Email_ID;
    }

    public String getBroker_ID() {
        return Broker_ID;
    }

    public void setBroker_ID(String broker_ID) {
        Broker_ID = broker_ID;
    }

    public String getBroker_Email() {
        return Broker_Email;
    }

    public void setBroker_Email(String broker_Email) {
        Broker_Email = broker_Email;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(boolean isdelete) {
        this.isdelete = isdelete;
    }

}
