package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Home_Builder")
public class Home_Builder {
    @Id
    @Column(name = "Home_Builder_ID")
    String Home_Builder_ID;

    @Column(name = "Home_Builder")
    String Home_Builder;

    @Column(name = "isdelete")
    boolean isdelete;

    public String getHome_Builder_ID() {
        return Home_Builder_ID;
    }

    public void setHome_Builder_ID(String home_Builder_ID) {
        Home_Builder_ID = home_Builder_ID;
    }

    public String getHome_Builder() {
        return Home_Builder;
    }

    public void setHome_Builder(String home_Builder) {
        Home_Builder = home_Builder;
    }

    public boolean isIsdelete() {
        return isdelete;
    }

    public void setIsdelete(boolean isdelete) {
        this.isdelete = isdelete;
    }
}
