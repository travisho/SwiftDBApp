package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Property_Style")
public class Property_Style {
    @Id
    @Column(name = "Property_Style_ID")
    String Property_Style_ID;

    @Column(name = "Style")
    String Style;

    public String getProperty_Style_ID() {
        return Property_Style_ID;
    }

    public void setProperty_Style_ID(String property_Style_ID) {
        Property_Style_ID = property_Style_ID;
    }

    public String getStyle() {
        return Style;
    }

    public void setStyle(String style) {
        Style = style;
    }
}
