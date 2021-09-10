package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Property_Survey")
public class Property_Survey {
    @Id
    @Column(name = "Property_Survey_ID")
    String Property_Survey_ID;

    @Column(name = "Property_ID")
    String Property_ID;

    @Column(name = "Survey_Document")
    String Survey_Document;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getProperty_Survey_ID() {
        return Property_Survey_ID;
    }

    public void setProperty_Survey_ID(String property_Survey_ID) {
        Property_Survey_ID = property_Survey_ID;
    }

    public String getProperty_ID() {
        return Property_ID;
    }

    public void setProperty_ID(String property_ID) {
        Property_ID = property_ID;
    }

    public String getSurvey_Document() {
        return Survey_Document;
    }

    public void setSurvey_Document(String survey_Document) {
        Survey_Document = survey_Document;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
