package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Home_Appraisal")
public class Home_Appraisal {
    @Id
    @Column(name = "Home_Appraisal_ID")
    String Home_Appraisal_ID;

    @Column(name = "Property_Finance_ID")
    String Property_Finance_ID;

    @Column(name = "Property_Area")
    String Property_Area;

    @Column(name = "Appraisal_Value")
    double Appraisal_Value;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getHome_Appraisal_ID() {
        return Home_Appraisal_ID;
    }

    public void setHome_Appraisal_ID(String home_Appraisal_ID) {
        Home_Appraisal_ID = home_Appraisal_ID;
    }

    public String getProperty_Finance_ID() {
        return Property_Finance_ID;
    }

    public void setProperty_Finance_ID(String property_Finance_ID) {
        Property_Finance_ID = property_Finance_ID;
    }

    public String getProperty_Area() {
        return Property_Area;
    }

    public void setProperty_Area(String property_Area) {
        Property_Area = property_Area;
    }

    public double getAppraisal_Value() {
        return Appraisal_Value;
    }

    public void setAppraisal_Value(double appraisal_Value) {
        Appraisal_Value = appraisal_Value;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
