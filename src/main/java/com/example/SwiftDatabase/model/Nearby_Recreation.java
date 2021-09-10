package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Nearby_Recreation")
public class Nearby_Recreation {
    @Id
    @Column(name = "Recreation_ID")
    String Recreation_ID;

    @Column(name = "Flyer_ID")
    String Flyer_ID;

    @Column(name = "Recreation")
    String Recreation;

    @Column(name = "Distance_From_Property")
    String Distance_From_Property;

    @Column(name = "Address")
    String Address;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getRecreation_ID() {
        return Recreation_ID;
    }

    public void setRecreation_ID(String recreation_ID) {
        Recreation_ID = recreation_ID;
    }

    public String getFlyer_ID() {
        return Flyer_ID;
    }

    public void setFlyer_ID(String flyer_ID) {
        Flyer_ID = flyer_ID;
    }

    public String getRecreation() {
        return Recreation;
    }

    public void setRecreation(String recreation) {
        Recreation = recreation;
    }

    public String getDistance_From_Property() {
        return Distance_From_Property;
    }

    public void setDistance_From_Property(String distance_From_Property) {
        Distance_From_Property = distance_From_Property;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
