package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Contract_Status")
public class Contract_Status {
    @Id
    @Column(name = "Contract_Status_ID")
    String Contract_Status_ID;

    @Column(name = "Contract_Status")
    String Contract_Status;

    public String getContract_Status_ID() {
        return Contract_Status_ID;
    }

    public void setContract_Status_ID(String contract_Status_ID) {
        Contract_Status_ID = contract_Status_ID;
    }

    public String getContract_Status() {
        return Contract_Status;
    }

    public void setContract_Status(String contract_Status) {
        Contract_Status = contract_Status;
    }
}
