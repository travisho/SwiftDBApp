package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Property_Remodel")
public class Property_Remodel {
    @Id
    @Column(name = "Remodel_ID")
    String Remodel_ID;

    @Column(name = "Property_ID")
    String Property_ID;

    @Column(name = "Date_of_Remodel")
    String Date_of_Remodel;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getRemodel_ID() {
        return Remodel_ID;
    }

    public void setRemodel_ID(String remodel_ID) {
        Remodel_ID = remodel_ID;
    }

    public String getProperty_ID() {
        return Property_ID;
    }

    public void setProperty_ID(String property_ID) {
        Property_ID = property_ID;
    }

    public String getDate_of_Remodel() {
        return Date_of_Remodel;
    }

    public void setDate_of_Remodel(String date_of_Remodel) {
        Date_of_Remodel = date_of_Remodel;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
