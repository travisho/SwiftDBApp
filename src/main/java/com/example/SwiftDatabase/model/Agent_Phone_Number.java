package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Agent_Phone_Number")
public class Agent_Phone_Number {
    @Id
    @Column(name = "Agent_Phone_Number_ID")
    String Agent_Phone_Number_ID;

    @Column(name = "Agent_ID")
    String Agent_ID;

    @Column(name = "Agent_Phone_Number")
    String Agent_Phone_Number;

    @Column(name = "Agent_Phone_Type")
    String Agent_Phone_Type;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getAgent_Phone_Number_ID() {
        return Agent_Phone_Number_ID;
    }

    public void setAgent_Phone_Number_ID(String agent_Phone_Number_ID) {
        Agent_Phone_Number_ID = agent_Phone_Number_ID;
    }

    public String getAgent_ID() {
        return Agent_ID;
    }

    public void setAgent_ID(String agent_ID) {
        Agent_ID = agent_ID;
    }

    public String getAgent_Phone_Number() {
        return Agent_Phone_Number;
    }

    public void setAgent_Phone_Number(String agent_Phone_Number) {
        Agent_Phone_Number = agent_Phone_Number;
    }

    public String getAgent_Phone_Type() {
        return Agent_Phone_Type;
    }

    public void setAgent_Phone_Type(String agent_Phone_Type) {
        Agent_Phone_Type = agent_Phone_Type;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
