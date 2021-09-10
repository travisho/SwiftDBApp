package com.example.SwiftDatabase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Broker_Phone_Number")
public  class Broker_Phone_Number {



    @Id
    @Column(name = "Broker_Phone_Number_ID")
    String Broker_Phone_Number_ID;

    @Column(name = "Broker_ID")
    String Broker_ID;

    @Column(name = "Broker_Phone_Number")
    String Broker_Phone_Number;

    @Column(name = "Broker_Phone_Type")
    String Broker_Phone_Type;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getBroker_Phone_Number_ID() {
        return Broker_Phone_Number_ID;
    }

    public void setBroker_Phone_Number_ID(String broker_Phone_Number_ID) {
        Broker_Phone_Number_ID = broker_Phone_Number_ID;
    }

    public String getBroker_ID() {
        return Broker_ID;
    }

    public void setBroker_ID(String broker_ID) {
        Broker_ID = broker_ID;
    }

    public String getBroker_Phone_Number() {
        return Broker_Phone_Number;
    }

    public void setBroker_Phone_Number(String broker_Phone_Number) {
        Broker_Phone_Number = broker_Phone_Number;
    }

    public String getBroker_Phone_Type() {
        return Broker_Phone_Type;
    }

    public void setBroker_Phone_Type(String broker_Phone_Type) {
        Broker_Phone_Type = broker_Phone_Type;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}