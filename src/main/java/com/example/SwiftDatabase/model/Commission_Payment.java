package com.example.SwiftDatabase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Commission_Payment")
public class Commission_Payment {

    @Id
    @Column(name = "Commission_Payment_ID")
    String Commission_Payment_ID;

    @Column(name = "Commission_Plan_ID")
    String  Commission_Plan_ID;

    @Column(name = "Payment_Amount")
    String  Payment_Amount;

    @Column(name = "Recipient")
    String  Recipient;

    @Column(name = "Date_of_Payment")
    String  Date_of_Payment;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getCommission_Payment_ID() {
        return Commission_Payment_ID;
    }

    public void setCommission_Payment_ID(String commission_Payment_ID) {
        Commission_Payment_ID = commission_Payment_ID;
    }

    public String getCommission_Plan_ID() {
        return Commission_Plan_ID;
    }

    public void setCommission_Plan_ID(String commission_Plan_ID) {
        Commission_Plan_ID = commission_Plan_ID;
    }

    public String getPayment_Amount() {
        return Payment_Amount;
    }

    public void setPayment_Amount(String payment_Amount) {
        Payment_Amount = payment_Amount;
    }

    public String getRecipient() {
        return Recipient;
    }

    public void setRecipient(String recipient) {
        Recipient = recipient;
    }

    public String getDate_of_Payment() {
        return Date_of_Payment;
    }

    public void setDate_of_Payment(String date_of_Payment) {
        Date_of_Payment = date_of_Payment;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
