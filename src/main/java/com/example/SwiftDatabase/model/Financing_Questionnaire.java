package com.example.SwiftDatabase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Financing_Questionnaire")
public class Financing_Questionnaire {

    @Column(name = "Financing_Arranged")
    String Financing_Arranged;

    @Column(name = "Loan_Amount")
    String Loan_Amount;

    @Column(name = "Loan_Letter_Insuance")
    String Loan_Letter_Insuance;

    @Column(name = "Enough_Funds_For_Earnest")
    String Enough_Funds_For_Earnest;

    @Column(name = "Lowest_Monthly_Range")
    String  Lowest_Monthly_Range;

    @Column(name = "Highest_Monthly_Range")
    String  Highest_Monthly_Range;

    @Id
    @Column(name = "Questionnaire_ID")
    String  Questionnaire_ID;

    @Column(name = "Lender_ID")
    String  Lender_ID;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getFinancing_Arranged() {
        return Financing_Arranged;
    }

    public void setFinancing_Arranged(String financing_Arranged) {
        Financing_Arranged = financing_Arranged;
    }

    public String getLoan_Amount() {
        return Loan_Amount;
    }

    public void setLoan_Amount(String loan_Amount) {
        Loan_Amount = loan_Amount;
    }

    public String getLoan_Letter_Insuance() {
        return Loan_Letter_Insuance;
    }

    public void setLoan_Letter_Insuance(String loan_Letter_Insuance) {
        Loan_Letter_Insuance = loan_Letter_Insuance;
    }

    public String getEnough_Funds_For_Earnest() {
        return Enough_Funds_For_Earnest;
    }

    public void setEnough_Funds_For_Earnest(String enough_Funds_For_Earnest) {
        Enough_Funds_For_Earnest = enough_Funds_For_Earnest;
    }

    public String getLowest_Monthly_Range() {
        return Lowest_Monthly_Range;
    }

    public void setLowest_Monthly_Range(String lowest_Monthly_Range) {
        Lowest_Monthly_Range = lowest_Monthly_Range;
    }

    public String getHighest_Monthly_Range() {
        return Highest_Monthly_Range;
    }

    public void setHighest_Monthly_Range(String highest_Monthly_Range) {
        Highest_Monthly_Range = highest_Monthly_Range;
    }

    public String getQuestionnaire_ID() {
        return Questionnaire_ID;
    }

    public void setQuestionnaire_ID(String questionnaire_ID) {
        Questionnaire_ID = questionnaire_ID;
    }

    public String getLender_ID() {
        return Lender_ID;
    }

    public void setLender_ID(String lender_ID) {
        Lender_ID = lender_ID;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
