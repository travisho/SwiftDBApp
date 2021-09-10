package com.example.SwiftDatabase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Pet")
public class Pet {

    @Id
    @Column(name = "Pet_ID")
    String Pet_ID;

    @Column(name = "Questionnaire_ID")
    String Questionnaire_ID;

    @Column(name = "Pet_Name")
    String Pet_Name;

    @Column(name = " Pet_Species")
    String Pet_Species;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getPet_ID() {
        return Pet_ID;
    }

    public void setPet_ID(String pet_ID) {
        Pet_ID = pet_ID;
    }

    public String getQuestionnaire_ID() {
        return Questionnaire_ID;
    }

    public void setQuestionnaire_ID(String questionnaire_ID) {
        Questionnaire_ID = questionnaire_ID;
    }

    public String getPet_Name() {
        return Pet_Name;
    }

    public void setPet_Name(String pet_Name) {
        Pet_Name = pet_Name;
    }

    public String getPet_Species() {
        return Pet_Species;
    }

    public void setPet_Species(String pet_Species) {
        Pet_Species = pet_Species;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
