package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Agent_Email")
public class Agent_Email {
    @Id
    @Column(name = "Agent_Email_ID")
    String Agent_Email_ID;

    @Column(name = "Agent_ID")
    String Agent_ID;

    @Column(name = "Agent_Email")
    String Agent_Email;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getAgent_Email_ID() {
        return Agent_Email_ID;
    }

    public void setAgent_Email_ID(String agent_Email_ID) {
        Agent_Email_ID = agent_Email_ID;
    }

    public String getAgent_ID() {
        return Agent_ID;
    }

    public void setAgent_ID(String agent_ID) {
        Agent_ID = agent_ID;
    }

    public String getAgent_Email() {
        return Agent_Email;
    }

    public void setAgent_Email(String agent_Email) {
        Agent_Email = agent_Email;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
