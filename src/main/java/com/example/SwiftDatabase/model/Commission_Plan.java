package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Commission_Plan")
public class Commission_Plan {
    @Id
    @Column(name = "Commission_Plan_ID")
    String Commission_Plan_ID;

    @Column(name = "Contract_ID")
    String Contract_ID;

    @Column(name = "Broker_ID")
    String Broker_ID;

    @Column(name = "Total_Commission")
    double Total_Commission;

    @Column(name = "Yun_Global_Commission_Percent")
    double Yun_Global_Commission_Percent;

    @Column(name = "Broker_Commission_Percent")
    double Broker_Commission_Percent;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getCommission_Plan_ID() {
        return Commission_Plan_ID;
    }

    public void setCommission_Plan_ID(String commission_Plan_ID) {
        Commission_Plan_ID = commission_Plan_ID;
    }

    public String getContract_ID() {
        return Contract_ID;
    }

    public void setContract_ID(String contract_ID) {
        Contract_ID = contract_ID;
    }

    public String getBroker_ID() {
        return Broker_ID;
    }

    public void setBroker_ID(String broker_ID) {
        Broker_ID = broker_ID;
    }

    public double getTotal_Commission() {
        return Total_Commission;
    }

    public void setTotal_Commission(double total_Commission) {
        Total_Commission = total_Commission;
    }

    public double getYun_Global_Commission_Percent() {
        return Yun_Global_Commission_Percent;
    }

    public void setYun_Global_Commission_Percent(double yun_Global_Commission_Percent) {
        Yun_Global_Commission_Percent = yun_Global_Commission_Percent;
    }

    public double getBroker_Commission_Percent() {
        return Broker_Commission_Percent;
    }

    public void setBroker_Commission_Percent(double broker_Commission_Percent) {
        Broker_Commission_Percent = broker_Commission_Percent;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
