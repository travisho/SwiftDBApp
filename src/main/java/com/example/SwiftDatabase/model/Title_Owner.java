package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Title_Owner")
public class Title_Owner {
    @Id
    @Column(name = "Title_Owner_ID")
    String Title_Owner_ID;

    @Column(name = "Property_ID")
    String Property_ID;

    @Column(name = "Title_Owner")
    String Title_Owner;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getTitle_Owner_ID() {
        return Title_Owner_ID;
    }

    public void setTitle_Owner_ID(String title_Owner_ID) {
        Title_Owner_ID = title_Owner_ID;
    }

    public String getProperty_ID() {
        return Property_ID;
    }

    public void setProperty_ID(String property_ID) {
        Property_ID = property_ID;
    }

    public String getTitle_Owner() {
        return Title_Owner;
    }

    public void setTitle_Owner(String title_Owner) {
        Title_Owner = title_Owner;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
