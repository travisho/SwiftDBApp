package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Contract_Type")
public class Contract_Type {
    @Id
    @Column(name = "Contract_Type_ID")
    String Contract_Type_ID;

    @Column(name = "Contract_Type")
    String Contract_Type;

    public String getContract_Type_ID() {
        return Contract_Type_ID;
    }

    public void setContract_Type_ID(String contract_Type_ID) {
        Contract_Type_ID = contract_Type_ID;
    }

    public String getContract_Type() {
        return Contract_Type;
    }

    public void setContract_Type(String contract_Type) {
        Contract_Type = contract_Type;
    }
}
