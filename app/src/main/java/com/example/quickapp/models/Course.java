package com.example.quickapp.models;

import java.io.Serializable;
import java.util.List;

public class Course implements Serializable {
    private  String idCourse;
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
    public String getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }

    public Course(String idCourse, String nameCourse) {
        this.idCourse = idCourse;
        this.nameCourse = nameCourse;
    }
    public Course( String namecCourse, List<Topic> topics) {
        this.nameCourse = namecCourse;

        this.topics = topics;
    }

    public Course() {
    }
}
