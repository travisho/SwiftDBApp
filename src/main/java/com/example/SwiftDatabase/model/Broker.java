package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Broker")
public class Broker {
    @Id
    @Column(name = "Broker_ID")
    String Broker_ID;

    @Column(name = "Broker_Company_ID")
    String Broker_Company_ID;

    @Column(name = "Broker_Name")
    String Broker_Name;


    @Column(name = "isdelete")
    Boolean isdelete;

    public String getBroker_ID() {
        return Broker_ID;
    }

    public void setBroker_ID(String broker_ID) {
        Broker_ID = broker_ID;
    }

    public String getBroker_Company_ID() {
        return Broker_Company_ID;
    }

    public void setBroker_Company_ID(String broker_Company_ID) {
        Broker_Company_ID = broker_Company_ID;
    }

    public String getBroker_Name() {
        return Broker_Name;
    }

    public void setBroker_Name(String broker_Name) {
        Broker_Name = broker_Name;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
