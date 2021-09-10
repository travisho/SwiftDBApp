package com.example.SwiftDatabase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Paycheck")
public class Paycheck {

    @Id
    @Column(name = "Paycheck_ID")
    String Paycheck_ID;

    @Column(name = "Agent_ID")
    String Agent_ID;

    @Column(name = "Paycheck_Amount")
    String Paycheck_Amount;

    @Column(name = "Date_Of_Payment")
    String Date_Of_Payment;

    @Column(name = "Month_Of_Services")
    String Month_Of_Services;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getPaycheck_ID() {
        return Paycheck_ID;
    }

    public void setPaycheck_ID(String paycheck_ID) {
        Paycheck_ID = paycheck_ID;
    }

    public String getAgent_ID() {
        return Agent_ID;
    }

    public void setAgent_ID(String agent_ID) {
        Agent_ID = agent_ID;
    }

    public String getPaycheck_Amount() {
        return Paycheck_Amount;
    }

    public void setPaycheck_Amount(String paycheck_Amount) {
        Paycheck_Amount = paycheck_Amount;
    }

    public String getDate_Of_Payment() {
        return Date_Of_Payment;
    }

    public void setDate_Of_Payment(String date_Of_Payment) {
        Date_Of_Payment = date_Of_Payment;
    }

    public String getMonth_Of_Services() {
        return Month_Of_Services;
    }

    public void setMonth_Of_Services(String month_Of_Services) {
        Month_Of_Services = month_Of_Services;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
