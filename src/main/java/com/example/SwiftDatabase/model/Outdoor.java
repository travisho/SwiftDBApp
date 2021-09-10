package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Outdoor")
public class Outdoor {
    @Id
    @Column(name = "Outdoor_ID")
    String Outdoor_ID;

    @Column(name = "Floor_Plan_ID")
    String Floor_Plan_ID;

    @Column(name = "Patio_Size_Area")
    int Patio_Size_Area;

    @Column(name = "Sprinkler_System")
    String Sprinkler_System;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getOutdoor_ID() {
        return Outdoor_ID;
    }

    public void setOutdoor_ID(String outdoor_ID) {
        Outdoor_ID = outdoor_ID;
    }

    public String getFloor_Plan_ID() {
        return Floor_Plan_ID;
    }

    public void setFloor_Plan_ID(String floor_Plan_ID) {
        Floor_Plan_ID = floor_Plan_ID;
    }

    public int getPatio_Size_Area() {
        return Patio_Size_Area;
    }

    public void setPatio_Size_Area(int patio_Size_Area) {
        Patio_Size_Area = patio_Size_Area;
    }

    public String getSprinkler_System() {
        return Sprinkler_System;
    }

    public void setSprinkler_System(String sprinkler_System) {
        Sprinkler_System = sprinkler_System;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
