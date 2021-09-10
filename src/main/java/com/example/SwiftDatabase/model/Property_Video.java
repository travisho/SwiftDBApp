package com.example.SwiftDatabase.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Property_Video")
public class Property_Video {
    @Id
    @Column(name = "Video_ID")
    String Video_ID;

    @Column(name = "Video")
    String Video;

    @Column(name = "Property_ID")
    String Property_ID;

    @Column(name = "isdelete")
    Boolean isdelete;

    public String getVideo_ID() {
        return Video_ID;
    }

    public void setVideo_ID(String video_ID) {
        Video_ID = video_ID;
    }

    public String getVideo() {
        return Video;
    }

    public void setVideo(String video) {
        Video = video;
    }

    public String getProperty_ID() {
        return Property_ID;
    }

    public void setProperty_ID(String property_ID) {
        Property_ID = property_ID;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
