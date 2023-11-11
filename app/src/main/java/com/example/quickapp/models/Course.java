package com.example.quickapp.models;

import java.io.Serializable;
import java.util.List;

public class Course implements Serializable {
    private String nameCourse;
    private List<Topic> topics;

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public Course( String namecCourse, List<Topic> topics) {
        this.nameCourse = namecCourse;

        this.topics = topics;
    }
}
