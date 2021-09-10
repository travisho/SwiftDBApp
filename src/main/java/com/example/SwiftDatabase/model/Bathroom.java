package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Bathroom")
public class Bathroom {
    @Id
    @Column(name = "Bathroom_ID")
    String Bathroom_ID;

    @Column(name = "Bathtub_Width")
    int Bathtub_Width;

    @Column(name = "Bathtub_Length")
    int Bathtub_Length;

    @Column(name = "Bathroom_Width")
    int Bathroom_Width;

    @Column(name = "Bathroom_Length")
    int Bathroom_Length;

    @Column(name = "Floor_Plan_ID")
    String Floor_Plan_ID;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getBathroom_ID() {
        return Bathroom_ID;
    }

    public void setBathroom_ID(String bathroom_ID) {
        Bathroom_ID = bathroom_ID;
    }

    public int getBathtub_Width() {
        return Bathtub_Width;
    }

    public void setBathtub_Width(int bathtub_Width) {
        Bathtub_Width = bathtub_Width;
    }

    public int getBathtub_Length() {
        return Bathtub_Length;
    }

    public void setBathtub_Length(int bathtub_Length) {
        Bathtub_Length = bathtub_Length;
    }

    public int getBathroom_Width() {
        return Bathroom_Width;
    }

    public void setBathroom_Width(int bathroom_Width) {
        Bathroom_Width = bathroom_Width;
    }

    public int getBathroom_Length() {
        return Bathroom_Length;
    }

    public void setBathroom_Length(int bathroom_Length) {
        Bathroom_Length = bathroom_Length;
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
