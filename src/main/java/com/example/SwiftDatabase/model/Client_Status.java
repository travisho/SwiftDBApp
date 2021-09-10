package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Client_Status")
public class Client_Status {
    @Id
    @Column(name = "Client_Status_ID")
    String Client_Status_ID;

    @Column(name = "Client_Status")
    String Client_Status;

    public String getClient_Status_ID() {
        return Client_Status_ID;
    }

    public void setClient_Status_ID(String client_Status_ID) {
        Client_Status_ID = client_Status_ID;
    }

    public String getClient_Status() {
        return Client_Status;
    }

    public void setClient_Status(String client_Status) {
        Client_Status = client_Status;
    }
}
