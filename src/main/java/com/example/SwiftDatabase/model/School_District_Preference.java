package com.example.SwiftDatabase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "School_District_Preference")
public class School_District_Preference {

    public String getSchool_District_ID() {
        return School_District_ID;
    }

    public void setSchool_District_ID(String school_District_ID) {
        School_District_ID = school_District_ID;
    }

    public String getQuestionnaire_ID() {
        return Questionnaire_ID;
    }

    public void setQuestionnaire_ID(String questionnaire_ID) {
        Questionnaire_ID = questionnaire_ID;
    }

    public String getSchool_District() {
        return School_District;
    }

    public void setSchool_District(String school_District) {
        School_District = school_District;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }

    @Id
    @Column(name = "School_District_ID")
    String School_District_ID;

    @Column(name = "Questionnaire_ID")
    String Questionnaire_ID;

    @Column(name = "School_District")
    String School_District;

    @Column(name = "isdelete")
    Boolean isdelete;
}