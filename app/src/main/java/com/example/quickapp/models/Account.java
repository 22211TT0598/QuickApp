package com.example.quickapp.models;

import java.io.Serializable;

public class Account implements Serializable {
    private String idMsvv;
    private  String tenDangNhap;
    private  String pass;

    public String getIdMsvv() {
        return idMsvv;
    }

    public void setIdMsvv(String idMsvv) {
        this.idMsvv = idMsvv;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


    public Account() {
    }

    public Account(String idMsvv, String tenDangNhap, String pass) {
        this.idMsvv = idMsvv;
        this.tenDangNhap = tenDangNhap;
        this.pass = pass;
    }
}
