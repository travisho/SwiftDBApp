package com.example.SwiftDatabase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Property_Inspection")

public class Seller_Disclosure_Form {

    @Id
    @Column(name = "Seller_Disclosure_Form_ID")
    String Seller_Disclosure_Form_ID;

    @Column(name = "Selling_Plan_ID")
    String Selling_Plan_ID;

    @Column(name = "Seller_Disclosure_Form")
    String Seller_Disclosure_Form;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getSeller_Disclosure_Form_ID() {
        return Seller_Disclosure_Form_ID;
    }

    public void setSeller_Disclosure_Form_ID(String seller_Disclosure_Form_ID) {
        Seller_Disclosure_Form_ID = seller_Disclosure_Form_ID;
    }

    public String getSelling_Plan_ID() {
        return Selling_Plan_ID;
    }

    public void setSelling_Plan_ID(String selling_Plan_ID) {
        Selling_Plan_ID = selling_Plan_ID;
    }

    public String getSeller_Disclosure_Form() {
        return Seller_Disclosure_Form;
    }

    public void setSeller_Disclosure_Form(String seller_Disclosure_Form) {
        Seller_Disclosure_Form = seller_Disclosure_Form;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
