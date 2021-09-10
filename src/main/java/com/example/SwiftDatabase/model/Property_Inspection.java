package com.example.SwiftDatabase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Property_Inspection")

public class Property_Inspection {

    @Id
    @Column(name = "Property_Inspection_ID")
    String Property_Inspection_ID;

    @Column(name = "Property_ID")
    String Property_ID;

    @Column(name = "Home_Inspection_Company_ID")
    String Home_Inspection_Company_ID;

    @Column(name = "Home_Inspection_PDF")
    String Home_Inspection_PDF;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getProperty_Inspection_ID() {
        return Property_Inspection_ID;
    }

    public void setProperty_Inspection_ID(String property_Inspection_ID) {
        Property_Inspection_ID = property_Inspection_ID;
    }

    public String getProperty_ID() {
        return Property_ID;
    }

    public void setProperty_ID(String property_ID) {
        Property_ID = property_ID;
    }

    public String getHome_Inspection_Company_ID() {
        return Home_Inspection_Company_ID;
    }

    public void setHome_Inspection_Company_ID(String home_Inspection_Company_ID) {
        Home_Inspection_Company_ID = home_Inspection_Company_ID;
    }

    public String getHome_Inspection_PDF() {
        return Home_Inspection_PDF;
    }

    public void setHome_Inspection_PDF(String home_Inspection_PDF) {
        Home_Inspection_PDF = home_Inspection_PDF;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
