package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Floor_Plan")
public class Floor_Plan {

    @Column(name = "Floor_Plan")
    String Floor_Plan;

    @Column(name = "Floor_Number")
    int Floor_Number;

    @Column(name = "Property_ID")
    String Property_ID;

    @Id
    @Column(name = "Floor_Plan_ID")
    String Floor_Plan_ID;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getFloor_Plan() {
        return Floor_Plan;
    }

    public void setFloor_Plan(String floor_Plan) {
        Floor_Plan = floor_Plan;
    }

    public int getFloor_Number() {
        return Floor_Number;
    }

    public void setFloor_Number(int floor_Number) {
        Floor_Number = floor_Number;
    }

    public String getProperty_ID() {
        return Property_ID;
    }

    public void setProperty_ID(String property_ID) {
        Property_ID = property_ID;
    }

    public String getFloor_Plan_ID() {
        return Floor_Plan_ID;
    }

    public void setFloor_Plan_ID(String floor_Plan_ID) {
        Floor_Plan_ID = floor_Plan_ID;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
