package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Home_Inspection_Company")
public class Home_Inspection_Company {
    @Id
    @Column(name = "Home_Inspection_Company_ID")
    String Home_Inspection_Company_ID;

    @Column(name = "Property_ID")
    String Property_ID;

    @Column(name = "Company_Name")
    String Company_Name;

    @Column(name = "Phone_Number")
    String Phone_Number;

    @Column(name = "Email")
    String Email;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getHome_Inspection_Company_ID() {
        return Home_Inspection_Company_ID;
    }

    public void setHome_Inspection_Company_ID(String home_Inspection_Company_ID) {
        Home_Inspection_Company_ID = home_Inspection_Company_ID;
    }

    public String getProperty_ID() {
        return Property_ID;
    }

    public void setProperty_ID(String property_ID) {
        Property_ID = property_ID;
    }

    public String getCompany_Name() {
        return Company_Name;
    }

    public void setCompany_Name(String company_Name) {
        Company_Name = company_Name;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        Phone_Number = phone_Number;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
