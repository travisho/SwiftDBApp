package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Property_Finance")
public class Property_Finance {
    @Id
    @Column(name = "Property_Finance_ID")
    String Property_Finance_ID;

    @Column(name = "Property_Tax")
    double Property_Tax;

    @Column(name = "Property_ID")
    String Property_ID;

    @Column(name = "Total_Price_Estimate")
    double Total_Price_Estimate;

    @Column(name = "Monthly_Price_Estimate")
    double Monthly_Price_Estimate;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getProperty_Finance_ID() {
        return Property_Finance_ID;
    }

    public void setProperty_Finance_ID(String property_Finance_ID) {
        Property_Finance_ID = property_Finance_ID;
    }

    public double getProperty_Tax() {
        return Property_Tax;
    }

    public void setProperty_Tax(double property_Tax) {
        Property_Tax = property_Tax;
    }

    public String getProperty_ID() {
        return Property_ID;
    }

    public void setProperty_ID(String property_ID) {
        Property_ID = property_ID;
    }

    public double getTotal_Price_Estimate() {
        return Total_Price_Estimate;
    }

    public void setTotal_Price_Estimate(double total_Price_Estimate) {
        Total_Price_Estimate = total_Price_Estimate;
    }

    public double getMonthly_Price_Estimate() {
        return Monthly_Price_Estimate;
    }

    public void setMonthly_Price_Estimate(double monthly_Price_Estimate) {
        Monthly_Price_Estimate = monthly_Price_Estimate;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
