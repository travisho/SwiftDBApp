package com.example.SwiftDatabase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Client_Email")
public class Client_Email {


    public String getClient_Email_ID() {
        return Client_Email_ID;
    }

    public void setClient_Email_ID(String client_Email_ID) {
        Client_Email_ID = client_Email_ID;
    }

    public String getClient_ID() {
        return Client_ID;
    }

    public void setClient_ID(String client_ID) {
        Client_ID = client_ID;
    }

    public String getClient_Email() {
        return Client_Email;
    }

    public void setClient_Email(String client_Email) {
        Client_Email = client_Email;
    }

    public boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(boolean isdelete) {
        this.isdelete = isdelete;
    }

    @Id
@Column(name = "Client_Email_ID")
    String Client_Email_ID;

@Column(name = "Client_ID")
    String Client_ID;

@Column(name = "Client_Email")
    String Client_Email;

@Column(name = "isdelete")
    boolean isdelete;

}