package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Appointment")
public class Appointment {
    @Id
    @Column(name = "Appointment_ID")
    String Appointment_ID;

    @Column(name = "Agent_ID")
    String Agent_ID;

    @Column(name = "Client_ID")
    String Client_ID;

    @Column(name = "Appointment_Date")
    String Appointment_Date;

    @Column(name = "Appointment_Time")
    String Appointment_Time;

    @Column(name = "Appointment_Topic")
    String Appointment_Topic;

    @Column(name = "Appointment_Summary")
    String Appointment_Summary;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getAppointment_ID() {
        return Appointment_ID;
    }

    public void setAppointment_ID(String appointment_ID) {
        Appointment_ID = appointment_ID;
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

    public void setClient_ID(String client_ID) { Client_ID = client_ID; }

    public String getAppointment_Date() { return Appointment_Date; }

    public void setAppointment_Date(String appointment_Date) {
        Appointment_Date = appointment_Date;
    }

    public String getAppointment_Time() {
        return Appointment_Time;
    }

    public void setAppointment_Time(String appointment_Time) { Appointment_Time = appointment_Time; }

    public String getAppointment_Topic() {
        return Appointment_Topic;
    }

    public void setAppointment_Topic(String appointment_Topic) {
        Appointment_Topic = appointment_Topic;
    }

    public String getAppointment_Summary() {
        return Appointment_Summary;
    }

    public void setAppointment_Summary(String appointment_Summary) {
        Appointment_Summary = appointment_Summary;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
