package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Heating_Unit")
public class Heating_Unit {
    @Id
    @Column(name = "Heating_Unit_ID")
    String Heating_Unit_ID;

    @Column(name = "Floor_Plan_ID")
    String Floor_Plan_ID;

    @Column(name = "Heating_Unit_Type")
    String Heating_Unit_Type;

    @Column(name = "Heating_Unit_Age")
    double Heating_Unit_Age_Years;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getHeating_Unit_ID() {
        return Heating_Unit_ID;
    }

    public void setHeating_Unit_ID(String heating_Unit_ID) {
        Heating_Unit_ID = heating_Unit_ID;
    }

    public String getFloor_Plan_ID() {
        return Floor_Plan_ID;
    }

    public void setFloor_Plan_ID(String floor_Plan_ID) {
        Floor_Plan_ID = floor_Plan_ID;
    }

    public String getHeating_Unit_Type() {
        return Heating_Unit_Type;
    }

    public void setHeating_Unit_Type(String heating_Unit_Type) {
        Heating_Unit_Type = heating_Unit_Type;
    }

    public double getHeating_Unit_Age_Years() {
        return Heating_Unit_Age_Years;
    }

    public void setHeating_Unit_Age_Years(double heating_Unit_Age_Years) {
        Heating_Unit_Age_Years = heating_Unit_Age_Years;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
