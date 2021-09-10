package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Appliance")
public class Appliance {

    @Column(name = "Appliance")
    String Appliance;

    @Column(name = "Warranty_Expiration_Date")
    String Warranty_Expiration_Date;

    @Column(name = "Property_ID")
    String Property_ID;

    @Id
    @Column(name = "Appliance_ID")
    String Appliance_ID;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getAppliance() {
        return Appliance;
    }

    public void setAppliance(String appliance) {
        Appliance = appliance;
    }

    public String getWarranty_Expiration_Date() {
        return Warranty_Expiration_Date;
    }

    public void setWarranty_Expiration_Date(String warranty_Expiration_Date) {
        Warranty_Expiration_Date = warranty_Expiration_Date;
    }

    public String getProperty_ID() {
        return Property_ID;
    }

    public void setProperty_ID(String property_ID) {
        Property_ID = property_ID;
    }

    public String getAppliance_ID() {
        return Appliance_ID;
    }

    public void setAppliance_ID(String appliance_ID) {
        Appliance_ID = appliance_ID;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
