package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Login")
public class Login {
    @Id
    @Column(name = "Login_ID")
    String Login_ID;

    @Column(name = "Username")
    String Username;

    @Column(name = "Password")
    String Password;

    @Column(name = "Agent_ID")
    String Agent_ID;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getLogin_ID() {
        return Login_ID;
    }

    public void setLogin_ID(String login_ID) {
        Login_ID = login_ID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getAgent_ID() {
        return Agent_ID;
    }

    public void setAgent_ID(String agent_ID) {
        Agent_ID = agent_ID;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
