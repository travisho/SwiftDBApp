package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Property_Flyer")
public class Property_Flyer {
    @Id
    @Column(name = "Flyer_ID")
    String Flyer_ID;

    @Column(name = "Property_ID")
    String Property_ID;

    @Column(name = "Fyler")
    String Fyler;


    @Column(name = "isdelete")
    Boolean isdelete;

    public String getFlyer_ID() {
        return Flyer_ID;
    }

    public void setFlyer_ID(String flyer_ID) {
        Flyer_ID = flyer_ID;
    }

    public String getProperty_ID() {
        return Property_ID;
    }

    public void setProperty_ID(String property_ID) {
        Property_ID = property_ID;
    }

    public String getFyler() {
        return Fyler;
    }

    public void setFyler(String fyler) {
        Fyler = fyler;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
