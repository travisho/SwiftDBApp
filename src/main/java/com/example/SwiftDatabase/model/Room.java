package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Room")
public class Room {
    @Id
    @Column(name = "Room_ID")
    String Room_ID;

    @Column(name = "Floor_Plan_ID")
    String Floor_Plan_ID;

    @Column(name = "Room_Type")
    String Room_Type;

    @Column(name = "Room_Area_ft")
    int Room_Area_ft;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getRoom_ID() {
        return Room_ID;
    }

    public void setRoom_ID(String room_ID) {
        Room_ID = room_ID;
    }

    public String getFloor_Plan_ID() {
        return Floor_Plan_ID;
    }

    public void setFloor_Plan_ID(String floor_Plan_ID) {
        Floor_Plan_ID = floor_Plan_ID;
    }

    public String getRoom_Type() {
        return Room_Type;
    }

    public void setRoom_Type(String room_Type) {
        Room_Type = room_Type;
    }

    public int getRoom_Area_ft() {
        return Room_Area_ft;
    }

    public void setRoom_Area_ft(int room_Area_ft) {
        Room_Area_ft = room_Area_ft;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
