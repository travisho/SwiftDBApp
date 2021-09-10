package com.example.SwiftDatabase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Utility_Bill")

public class Utility_Bill {

    @Id
    @Column(name = "Utility_Bill_ID")
    String Utility_Bill_ID;

    @Column(name = "Property_Finance_ID")
    String Property_Finance_ID;

    @Column(name = "Utility")
    String Utility;

    @Column(name = "Cost_Of_Utility")
    String Cost_Of_Utility;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getUtility_Bill_ID() {
        return Utility_Bill_ID;
    }

    public void setUtility_Bill_ID(String utility_Bill_ID) {
        Utility_Bill_ID = utility_Bill_ID;
    }

    public String getProperty_Finance_ID() {
        return Property_Finance_ID;
    }

    public void setProperty_Finance_ID(String property_Finance_ID) {
        Property_Finance_ID = property_Finance_ID;
    }

    public String getUtility() {
        return Utility;
    }

    public void setUtility(String utility) {
        Utility = utility;
    }

    public String getCost_Of_Utility() {
        return Cost_Of_Utility;
    }

    public void setCost_Of_Utility(String cost_Of_Utility) {
        Cost_Of_Utility = cost_Of_Utility;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
