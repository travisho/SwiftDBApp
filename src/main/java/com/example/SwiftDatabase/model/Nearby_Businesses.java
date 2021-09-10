package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Nearby_Businesses")
public class Nearby_Businesses {
    @Id
    @Column(name = "Nearby_Businesses_ID")
    String Nearby_Businesses_ID;

    @Column(name = "Flyer_ID")
    String Flyer_ID;

    @Column(name = "Business")
    String Business;

    @Column(name = "Distance_from_Property")
    String Distance_from_Property;

    @Column(name = "Address")
    String Address;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getNearby_Businesses_ID() {
        return Nearby_Businesses_ID;
    }

    public void setNearby_Businesses_ID(String nearby_Businesses_ID) {
        Nearby_Businesses_ID = nearby_Businesses_ID;
    }

    public String getFlyer_ID() {
        return Flyer_ID;
    }

    public void setFlyer_ID(String flyer_ID) {
        Flyer_ID = flyer_ID;
    }

    public String getBusiness() {
        return Business;
    }

    public void setBusiness(String business) {
        Business = business;
    }

    public String getDistance_from_Property() {
        return Distance_from_Property;
    }

    public void setDistance_from_Property(String distance_from_Property) {
        Distance_from_Property = distance_from_Property;
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
