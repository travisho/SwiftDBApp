package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Questionnaire")
public class Questionnaire {
    @Id
    @Column(name = "Questionnaire_ID")
    String Questionnaire_ID;

    @Column(name = "Client_ID")
    String Client_ID;

    @Column(name = "Preferred_Location")
    String Preferred_Location;

    @Column(name = "Amount_Of_Children")
    int Amount_Of_Children;

    @Column(name = "Current_Ownership_Status")
    String Current_Ownership_Status;

    @Column(name = "Preferred_Move_In_Date")
    Date Preferred_Move_In_Date;

    @Column(name = "New_Or_Resale_Preference")
    String New_Or_Resale_Preference;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getQuestionnaire_ID() {
        return Questionnaire_ID;
    }

    public void setQuestionnaire_ID(String questionnaire_ID) {
        Questionnaire_ID = questionnaire_ID;
    }

    public String getClient_ID() {
        return Client_ID;
    }

    public void setClient_ID(String client_ID) {
        Client_ID = client_ID;
    }

    public String getPreferred_Location() {
        return Preferred_Location;
    }

    public void setPreferred_Location(String preferred_Location) {
        Preferred_Location = preferred_Location;
    }

    public int getAmount_Of_Children() {
        return Amount_Of_Children;
    }

    public void setAmount_Of_Children(int amount_Of_Children) {
        Amount_Of_Children = amount_Of_Children;
    }

    public String getCurrent_Ownership_Status() {
        return Current_Ownership_Status;
    }

    public void setCurrent_Ownership_Status(String current_Ownership_Status) {
        Current_Ownership_Status = current_Ownership_Status;
    }

    public Date getPreferred_Move_In_Date() {
        return Preferred_Move_In_Date;
    }

    public void setPreferred_Move_In_Date(Date preferred_Move_In_Date) {
        Preferred_Move_In_Date = preferred_Move_In_Date;
    }

    public String getNew_Or_Resale_Preference() {
        return New_Or_Resale_Preference;
    }

    public void setNew_Or_Resale_Preference(String new_Or_Resale_Preference) {
        New_Or_Resale_Preference = new_Or_Resale_Preference;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
