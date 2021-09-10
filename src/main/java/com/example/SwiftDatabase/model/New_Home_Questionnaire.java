package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "New_Home_Questionnaire")
public class New_Home_Questionnaire {

    @Column(name = "Style_Preference")
    String Style_Preference;

    @Column(name = "Stairs_Prefernce")
    String Stairs_Prefernce;

    @Column(name = "Master_Bathroom")
    String Master_Bathroom;

    @Column(name = "Property_Area")
    int Property_Area;

    @Column(name = "Open_Floor_Plan")
    String Open_Floor_Plan;

    @Column(name = "Office/Study")
    String Office_Study;

    @Column(name = "Formal_Dining_Room")
    String Formal_Dining_Room;

    @Column(name = "Patio_Or_Deck")
    String Patio_Or_Deck;

    @Column(name = "Sprinkler_System")
    String Sprinkler_System;

    @Column(name = "Garage")
    String Garage;

    @Column(name = "Garage_Car_Capacity")
    int Garage_Car_Capacity;

    @Column(name = "Lot_Size_Preference_Area")
    int Lot_Size_Preference_Area;

    @Id
    @Column(name = "Questionnaire_ID")
    String Questionnaire_ID;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getStyle_Preference() {
        return Style_Preference;
    }

    public void setStyle_Preference(String style_Preference) {
        Style_Preference = style_Preference;
    }

    public String getStairs_Prefernce() {
        return Stairs_Prefernce;
    }

    public void setStairs_Prefernce(String stairs_Prefernce) {
        Stairs_Prefernce = stairs_Prefernce;
    }

    public String getMaster_Bathroom() {
        return Master_Bathroom;
    }

    public void setMaster_Bathroom(String master_Bathroom) {
        Master_Bathroom = master_Bathroom;
    }

    public int getProperty_Area() {
        return Property_Area;
    }

    public void setProperty_Area(int property_Area) {
        Property_Area = property_Area;
    }

    public String getOpen_Floor_Plan() {
        return Open_Floor_Plan;
    }

    public void setOpen_Floor_Plan(String open_Floor_Plan) {
        Open_Floor_Plan = open_Floor_Plan;
    }

    public String getOffice_Study() {
        return Office_Study;
    }

    public void setOffice_Study(String office_Study) {
        Office_Study = office_Study;
    }

    public String getFormal_Dining_Room() {
        return Formal_Dining_Room;
    }

    public void setFormal_Dining_Room(String formal_Dining_Room) {
        Formal_Dining_Room = formal_Dining_Room;
    }

    public String getPatio_Or_Deck() {
        return Patio_Or_Deck;
    }

    public void setPatio_Or_Deck(String patio_Or_Deck) {
        Patio_Or_Deck = patio_Or_Deck;
    }

    public String getSprinkler_System() {
        return Sprinkler_System;
    }

    public void setSprinkler_System(String sprinkler_System) {
        Sprinkler_System = sprinkler_System;
    }

    public String getGarage() {
        return Garage;
    }

    public void setGarage(String garage) {
        Garage = garage;
    }

    public int getGarage_Car_Capacity() {
        return Garage_Car_Capacity;
    }

    public void setGarage_Car_Capacity(int garage_Car_Capacity) {
        Garage_Car_Capacity = garage_Car_Capacity;
    }

    public int getLot_Size_Preference_Area() {
        return Lot_Size_Preference_Area;
    }

    public void setLot_Size_Preference_Area(int lot_Size_Preference_Area) {
        Lot_Size_Preference_Area = lot_Size_Preference_Area;
    }

    public String getQuestionnaire_ID() {
        return Questionnaire_ID;
    }

    public void setQuestionnaire_ID(String questionnaire_ID) {
        Questionnaire_ID = questionnaire_ID;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
