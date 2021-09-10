package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Mortgage_Document")
public class Mortgage_Document {
    @Id
    @Column(name = "Mortgage_Document_ID")
    String Mortgage_Document_ID;

    @Column(name = "Mortgage_Document")
    String Mortgage_Document;

    @Column(name = "Property_Finance_ID")
    String Property_Finance_ID;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getMortgage_Document_ID() {
        return Mortgage_Document_ID;
    }

    public void setMortgage_Document_ID(String mortgage_Document_ID) {
        Mortgage_Document_ID = mortgage_Document_ID;
    }

    public String getMortgage_Document() {
        return Mortgage_Document;
    }

    public void setMortgage_Document(String mortgage_Document) {
        Mortgage_Document = mortgage_Document;
    }

    public String getProperty_Finance_ID() {
        return Property_Finance_ID;
    }

    public void setProperty_Finance_ID(String property_Finance_ID) {
        Property_Finance_ID = property_Finance_ID;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
