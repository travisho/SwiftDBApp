package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Garage")
public class Garage {
    @Id
    @Column(name = "Garage_ID")
    String Garage_ID;

    @Column(name = "Garage_Width")
    int Garage_Width_ft;

    @Column(name = "Garage_Length")
    int Garage_Length_ft;

    @Column(name = "Garage_Car_Capacity")
    int Garage_Car_Capacity;

    @Column(name = "Floor_Plan_ID")
    String Floor_Plan_ID;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getGarage_ID() {
        return Garage_ID;
    }

    public void setGarage_ID(String garage_ID) {
        Garage_ID = garage_ID;
    }

    public int getGarage_Width_ft() {
        return Garage_Width_ft;
    }

    public void setGarage_Width_ft(int garage_Width_ft) {
        Garage_Width_ft = garage_Width_ft;
    }

    public int getGarage_Length_ft() {
        return Garage_Length_ft;
    }

    public void setGarage_Length_ft(int garage_Length_ft) {
        Garage_Length_ft = garage_Length_ft;
    }

    public int getGarage_Car_Capacity() {
        return Garage_Car_Capacity;
    }

    public void setGarage_Car_Capacity(int garage_Car_Capacity) {
        Garage_Car_Capacity = garage_Car_Capacity;
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
