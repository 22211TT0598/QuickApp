package com.example.quickapp.models;

import java.util.List;

public class Student {
    private  String mssv;
    private  String name;
    private String idHistory;

    private List<History>listHistory;

    public String getIdHistory() {
        return idHistory;
    }

    public void setIdHistory(String idHistory) {
        this.idHistory = idHistory;
    }

    public List<History> getListHistory() {
        return listHistory;
    }

    public void setListHistory(List<History> listHistory) {
        this.listHistory = listHistory;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(String mssv, String name, String idHistory) {
        this.mssv = mssv;
        this.name = name;
        this.idHistory = idHistory;
    }

    public Student(String mssv, String name, List<History> listHistory) {
        this.mssv = mssv;
        this.name = name;
        this.idHistory = idHistory;
        this.listHistory = listHistory;
    }

    public Student() {
    }
}
