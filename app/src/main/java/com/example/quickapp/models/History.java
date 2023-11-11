package com.example.quickapp.models;

public class History {
   private String mssv,name;
    private String sorce;
    private String Finishtime;

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

    public String getSorce() {
        return sorce;
    }

    public void setSorce(String sorce) {
        this.sorce = sorce;
    }

    public String getFinishtime() {
        return Finishtime;
    }

    public void setFinishtime(String finishtime) {
        Finishtime = finishtime;
    }

    public History(String mssv, String name, String sorce, String Finishtime){
        this.mssv=mssv;
        this.name=name;
        this.sorce=sorce;
        this.Finishtime=Finishtime;
    }
}
