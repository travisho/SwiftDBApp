package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Broker_Company")
public class Broker_Company {
    @Id
    @Column(name = "Broker_Company_ID")
    String Broker_Company_ID;

    @Column(name = "Broker_Company")
    String Broker_Company;


    @Column(name = "isdelete")
    Boolean isdelete;

    public String getBroker_Company_ID() {
        return Broker_Company_ID;
    }

    public void setBroker_Company_ID(String broker_Company_ID) {
        Broker_Company_ID = broker_Company_ID;
    }

    public String getBroker_Company() {
        return Broker_Company;
    }

    public void setBroker_Company(String broker_Company) {
        Broker_Company = broker_Company;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
