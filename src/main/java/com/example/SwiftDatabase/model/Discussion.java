package com.example.SwiftDatabase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Discussion")
public class Discussion {


    public String getDiscussion_ID() {
        return Discussion_ID;
    }

    public void setDiscussion_ID(String discussion_ID) {
        Discussion_ID = discussion_ID;
    }

    public String getAgent_ID() {
        return Agent_ID;
    }

    public void setAgent_ID(String agent_ID) {
        Agent_ID = agent_ID;
    }

    public String getClient_ID() {
        return Client_ID;
    }

    public void setClient_ID(String client_ID) {
        Client_ID = client_ID;
    }

    public String getDiscussion_Medium_ID() {
        return Discussion_Medium_ID;
    }

    public void setDiscussion_Medium_ID(String discussion_Medium_ID) {
        Discussion_Medium_ID = discussion_Medium_ID;
    }

    public int getDiscussion_Time() {
        return Discussion_Time;
    }

    public void setDiscussion_Time(int discussion_Time) {
        Discussion_Time = discussion_Time;
    }

    public String getDiscussion_Topic() {
        return Discussion_Topic;
    }

    public void setDiscussion_Topic(String discussion_Topic) {
        Discussion_Topic = discussion_Topic;
    }

    public String getDiscussion_Summary() {
        return Discussion_Summary;
    }

    public void setDiscussion_Summary(String discussion_Summary) {
        Discussion_Summary = discussion_Summary;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }

    @Id
    @Column(name = "Discussion_ID")
    String Discussion_ID;

    @Column(name = "Agent_ID")
    String Agent_ID;

    @Column(name = "Client_ID")
    String Client_ID;

    @Column(name = "Discussion_Medium_ID")
    String Discussion_Medium_ID;

    @Column(name = "Discussion_Time")
    int Discussion_Time;

    @Column(name = "Discussion_Topic")
    String Discussion_Topic;

    @Column(name = "Discussion_Summary")
    String Discussion_Summary;

    @Column(name = "isdelete")
    Boolean isdelete;
}