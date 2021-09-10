package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Air_Conditioning_Unit")
public class Air_Conditioning_Unit {
    @Id
    @Column(name = "ACU_ID")
    String ACU_ID;

    @Column(name = "Floor_Plan_ID")
    String Floor_Plan_ID;

    @Column(name = "ACU_Type")
    String ACU_Type;

    @Column(name = "ACU_Age")
    double ACU_Age_Years;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getACU_ID() {
        return ACU_ID;
    }

    public void setACU_ID(String ACU_ID) {
        this.ACU_ID = ACU_ID;
    }

    public String getFloor_Plan_ID() {
        return Floor_Plan_ID;
    }

    public void setFloor_Plan_ID(String floor_Plan_ID) {
        Floor_Plan_ID = floor_Plan_ID;
    }

    public String getACU_Type() {
        return ACU_Type;
    }

    public void setACU_Type(String ACU_Type) {
        this.ACU_Type = ACU_Type;
    }

    public double getACU_Age_Years() {
        return ACU_Age_Years;
    }

    public void setACU_Age_Years(double ACU_Age_Years) {
        this.ACU_Age_Years = ACU_Age_Years;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
