package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Property_Photo")
public class Property_Photo {
    @Id
    @Column(name = "Photo_ID")
    String Photo_ID;

    @Column(name = "Photo")
    String Photo;

    @Column(name = "Property_ID")
    String Property_ID;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getPhoto_ID() {
        return Photo_ID;
    }

    public void setPhoto_ID(String photo_ID) {
        Photo_ID = photo_ID;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

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
