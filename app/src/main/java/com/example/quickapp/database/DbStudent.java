package com.example.quickapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.quickapp.models.Course;
import com.example.quickapp.models.Student;

import java.util.ArrayList;
import java.util.List;

public class DbStudent extends DbHistory{
    public final String tbStudent="tbStudent";
    public final String mssv="mssv";
    public final String nameStudent="nameStudent";

    public DbStudent(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "QuickApp", factory, version);
    }

    public List<Student> getListStudent() {
        List<Student> list = new ArrayList<>();
        String query = "select * from " + tbStudent;
        Cursor cr = this.getReadableDatabase().rawQuery(query, null);
        while (cr.moveToNext()) {
            Student cs = new Student(cr.getString(0), cr.getString(1),cr.getString(2));
            list.add(cs);
        }
        return list;
    }

    public void addStudent(String idCs,String nameCs,String idH) {
        ContentValues values=new ContentValues();
        values.put(nameStudent,nameCs);
        values.put(mssv,idCs);
        values.put(idHistory,idH);
        this.getWritableDatabase().insert(tbStudent,null,values);
    }
    public void deleteStudent(String idCs) {
        String query=mssv+"=?";
        this.getWritableDatabase().delete(tbStudent,query,new String []{idCs});
    }
    public void updateStudent(String idCs,String name) {
        ContentValues values=new ContentValues();
        values.put(nameStudent,name);
        String query=mssv+"=?";
        this.getWritableDatabase().update(tbStudent,values,query,new String []{idCs});
    }
}
