package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Client")
public class Client {
    @Id
    @Column(name = "Client_ID")
    String Client_ID;

    @Column(name = "Client_First_Name")
    String Client_First_Name;

    @Column(name = "Client_Last_Name")
    String Client_Last_Name;

    @Column(name = "Client_Status_ID")
    String Client_Status_ID;

    @Column(name = "Client_Type")
    String Client_Type;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getClient_ID() {
        return Client_ID;
    }

    public void setClient_ID(String client_ID) {
        Client_ID = client_ID;
    }

    public String getClient_First_Name() {
        return Client_First_Name;
    }

    public void setClient_First_Name(String client_First_Name) {
        Client_First_Name = client_First_Name;
    }

    public String getClient_Last_Name() {
        return Client_Last_Name;
    }

    public void setClient_Last_Name(String client_Last_Name) {
        Client_Last_Name = client_Last_Name;
    }

    public String getClient_Status_ID() {
        return Client_Status_ID;
    }

    public void setClient_Status_ID(String client_Status_ID) {
        Client_Status_ID = client_Status_ID;
    }

    public String getClient_Type() {
        return Client_Type;
    }

    public void setClient_Type(String client_Type) {
        Client_Type = client_Type;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
