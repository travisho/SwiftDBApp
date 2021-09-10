package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Open_House_Session")
public class Open_House_Session {
    @Id
    @Column(name = "Open_House_ID")
    String Open_House_ID;

    @Column(name = "Date_Of_Open_House")
    String Date_Of_Open_House;

    @Column(name = "Property_ID")
    String Property_ID;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getOpen_House_ID() {
        return Open_House_ID;
    }

    public void setOpen_House_ID(String open_House_ID) {
        Open_House_ID = open_House_ID;
    }

    public String getDate_Of_Open_House() {
        return Date_Of_Open_House;
    }

    public void setDate_Of_Open_House(String date_Of_Open_House) { Date_Of_Open_House = date_Of_Open_House; }

    public String getProperty_ID() {
        return Property_ID;
    }

    public void setProperty_ID(String property_ID) {
        Property_ID = property_ID;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}

