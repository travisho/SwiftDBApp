package com.example.SwiftDatabase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Agent")
public class Agent {

    public String getAgent_ID() {
        return Agent_ID;
    }

    public void setAgent_ID(String agent_ID) {
        Agent_ID = agent_ID;
    }

    public String getAgent_First_Name() {
        return Agent_First_Name;
    }

    public void setAgent_First_Name(String agent_First_Name) {
        Agent_First_Name = agent_First_Name;
    }

    public String getAgent_Last_Name() {
        return Agent_Last_Name;
    }

    public void setAgent_Last_Name(String agent_Last_Name) {
        Agent_Last_Name = agent_Last_Name;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }

    @Id
    @Column(name = "Agent_ID")
    String Agent_ID;

    @Column(name = "Agent_First_Name")
    String Agent_First_Name;

    @Column(name = "Agent_Last_Name")
    String Agent_Last_Name;

    @Column(name = "Title")
    String Title;

    @Column(name = "isdelete")
    Boolean isdelete;



}
