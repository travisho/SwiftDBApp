package com.example.SwiftDatabase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Client_Phone_Number")
public class Client_Phone_Number {


    public String getClient_Phone_Number_ID() {
        return Client_Phone_Number_ID;
    }

    public void setClient_Phone_Number_ID(String client_Phone_Number_ID) {
        Client_Phone_Number_ID = client_Phone_Number_ID;
    }

    public String getClient_ID() {
        return Client_ID;
    }

    public void setClient_ID(String client_ID) {
        Client_ID = client_ID;
    }

    public String getClient_Phone_Number() {
        return Client_Phone_Number;
    }

    public void setClient_Phone_Number(String client_Phone_Number) {
        Client_Phone_Number = client_Phone_Number;
    }

    public String getClient_Type() {
        return Client_Type;
    }

    public void setClient_Type(String client_Type) {
        Client_Type = client_Type;
    }

    public boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(boolean isdelete) {
        this.isdelete = isdelete;
    }

    @Id
    @Column(name = "Client_Phone_Number_ID")
    String Client_Phone_Number_ID;

    @Column(name = "Client_ID")
    String Client_ID;

    @Column(name = "Client_Phone_Number")
    String Client_Phone_Number;

    @Column(name = "Client_Type")
    String Client_Type;

    @Column(name = "isdelete")
    boolean isdelete;
}