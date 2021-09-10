package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Discussion_Medium")
public class Discussion_Medium {
    @Id
    @Column(name = "Discussion_Medium_ID")
    String Discussion_Medium_ID;

    @Column(name = "Discussion_Medium")
    String Discussion_Medium;

    public String getDiscussion_Medium_ID() {
        return Discussion_Medium_ID;
    }

    public void setDiscussion_Medium_ID(String discussion_Medium_ID) {
        Discussion_Medium_ID = discussion_Medium_ID;
    }

    public String getDiscussion_Medium() {
        return Discussion_Medium;
    }

    public void setDiscussion_Medium(String discussion_Medium) {
        Discussion_Medium = discussion_Medium;
    }
}
