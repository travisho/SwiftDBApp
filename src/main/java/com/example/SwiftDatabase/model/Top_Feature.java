package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Top_Feature")
public class Top_Feature {
    @Id
    @Column(name = "Top_Feature_ID")
    String Top_Feature_ID;

    @Column(name = "Property_ID")
    String Property_ID;

    @Column(name = "Top_Feature")
    String Top_Feature;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getTop_Feature_ID() {
        return Top_Feature_ID;
    }

    public void setTop_Feature_ID(String top_Feature_ID) {
        Top_Feature_ID = top_Feature_ID;
    }

    public String getProperty_ID() {
        return Property_ID;
    }

    public void setProperty_ID(String property_ID) {
        Property_ID = property_ID;
    }

    public String getTop_Feature() {
        return Top_Feature;
    }

    public void setTop_Feature(String top_Feature) {
        Top_Feature = top_Feature;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
