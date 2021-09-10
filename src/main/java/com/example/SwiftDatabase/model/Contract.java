package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "Contract")
public class Contract {
    @Id
    @Column(name = "Contract_ID")
    String Contract_ID;

    @Column(name = "Client_ID")
    String Client_ID;

    @Column(name = "Agent_ID")
    String Agent_ID;

    @Column(name = "Property_ID")
    String Property_ID;

    @Column(name = "Contract_Status_ID")
    String Contract_Status_ID;

    @Column(name = "Contract_Type_ID")
    String Contract_Type_ID;

    @Column(name = "Move_In_Date")
    String Move_In_Date;

    @Column(name = "Desired_City")
    String Desired_City;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getContract_ID() {
        return Contract_ID;
    }

    public void setContract_ID(String contract_ID) {
        Contract_ID = contract_ID;
    }

    public String getClient_ID() {
        return Client_ID;
    }

    public void setClient_ID(String client_ID) {
        Client_ID = client_ID;
    }

    public String getAgent_ID() {
        return Agent_ID;
    }

    public void setAgent_ID(String agent_ID) {
        Agent_ID = agent_ID;
    }

    public String getProperty_ID() {
        return Property_ID;
    }

    public void setProperty_ID(String property_ID) {
        Property_ID = property_ID;
    }

    public String getContract_Status_ID() {
        return Contract_Status_ID;
    }

    public void setContract_Status_ID(String contract_Status_ID) {
        Contract_Status_ID = contract_Status_ID;
    }

    public String getContract_Type_ID() {
        return Contract_Type_ID;
    }

    public void setContract_Type_ID(String contract_Type_ID) {
        Contract_Type_ID = contract_Type_ID;
    }

    public String getMove_In_Date() {
        return Move_In_Date;
    }

    public void setMove_In_Date(String move_In_Date) {
        Move_In_Date = move_In_Date;
    }

    public String getDesired_City() {
        return Desired_City;
    }

    public void setDesired_City(String desired_City) {
        Desired_City = desired_City;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
