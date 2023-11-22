package com.example.quickapp.models;

public class History {
    private String idHistory;
    private String score;
    private String finishTime;

    public String getIdHistory() {
        return idHistory;
    }

    public void setIdHistory(String idHistory) {
        this.idHistory = idHistory;
    }

    public String getSorce() {
        return score;
    }

    public void setSorce(String sorce) {
        this.score = sorce;
    }

    public String getFinishtime() {
        return finishTime;
    }

    public void setFinishtime(String finishtime) {
        this.finishTime = finishtime;
    }

    public History(String idHistory, String sorce, String finishtime) {
        this.idHistory = idHistory;
        this.score = sorce;
        this.finishTime = finishtime;
    }

    public History() {
    }
}
