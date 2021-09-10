package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "State")
public class State {
    @Id
    @Column(name = "State_ID")
    String State_ID;

    @Column(name = "State_Name")
    String State_Name;

    @Column(name = "State_Abbereviation")
    String State_Abbereviation;

    public String getState_ID() {
        return State_ID;
    }

    public void setState_ID(String state_ID) {
        State_ID = state_ID;
    }

    public String getState_Name() {
        return State_Name;
    }

    public void setState_Name(String state_Name) {
        State_Name = state_Name;
    }

    public String getState_Abbereviation() {
        return State_Abbereviation;
    }

    public void setState_Abbereviation(String state_Abbereviation) {
        State_Abbereviation = state_Abbereviation;
    }
}
