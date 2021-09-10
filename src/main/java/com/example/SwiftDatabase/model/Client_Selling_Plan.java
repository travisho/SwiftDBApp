package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Client_Selling_Plan")
public class Client_Selling_Plan {
    @Id
    @Column(name = "Selling_Plan_ID")
    String Selling_Plan_ID;

    @Column(name = "Contract_ID")
    String Contract_ID;

    @Column(name = "Listing_Price")
    double Listing_Price;

    @Column(name = "Lowest_Price")
    double Lowest_Price;

    @Column(name = "Ideal_Price")
    double Ideal_Price;

    @Column(name = "Overall_Commission_%")
    double Overall_Commission;

    @Column(name = "Agent_Commission_%")
    double Agent_Commission;

    @Column(name = "Starting_Ideal_Timeframe_(Date)")
    Date Starting_Ideal_Timeframe_Date;

    @Column(name = "Ending_Ideal_Timeframe_(Date)")
    Date Ending_Ideal_Timeframe_Date;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getSelling_Plan_ID() {
        return Selling_Plan_ID;
    }

    public void setSelling_Plan_ID(String selling_Plan_ID) {
        Selling_Plan_ID = selling_Plan_ID;
    }

    public String getContract_ID() {
        return Contract_ID;
    }

    public void setContract_ID(String contract_ID) {
        Contract_ID = contract_ID;
    }

    public double getListing_Price() {
        return Listing_Price;
    }

    public void setListing_Price(double listing_Price) {
        Listing_Price = listing_Price;
    }

    public double getLowest_Price() {
        return Lowest_Price;
    }

    public void setLowest_Price(double lowest_Price) {
        Lowest_Price = lowest_Price;
    }

    public double getIdeal_Price() {
        return Ideal_Price;
    }

    public void setIdeal_Price(double ideal_Price) {
        Ideal_Price = ideal_Price;
    }

    public double getOverall_Commission() {
        return Overall_Commission;
    }

    public void setOverall_Commission(double overall_Commission) {
        Overall_Commission = overall_Commission;
    }

    public double getAgent_Commission() {
        return Agent_Commission;
    }

    public void setAgent_Commission(double agent_Commission) {
        Agent_Commission = agent_Commission;
    }

    public Date getStarting_Ideal_Timeframe_Date() {
        return Starting_Ideal_Timeframe_Date;
    }

    public void setStarting_Ideal_Timeframe_Date(Date starting_Ideal_Timeframe_Date) {
        Starting_Ideal_Timeframe_Date = starting_Ideal_Timeframe_Date;
    }

    public Date getEnding_Ideal_Timeframe_Date() {
        return Ending_Ideal_Timeframe_Date;
    }

    public void setEnding_Ideal_Timeframe_Date(Date ending_Ideal_Timeframe_Date) {
        Ending_Ideal_Timeframe_Date = ending_Ideal_Timeframe_Date;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
