package com.example.quickapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.quickapp.models.Course;

import java.util.ArrayList;
import java.util.List;


public class DbCourse extends DbAccCount {

    public final String idCourse = "idCourse";
    public final String tbCourse = "tbCourse";
    public final String nameCourse = "nameCourse";

    public DbCourse(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "QuickApp", factory, version);
    }

    public List<Course> getListCourse() {
        List<Course> list = new ArrayList<>();
        String query = "select * from " + tbCourse;
        Cursor cr = this.getReadableDatabase().rawQuery(query, null);
        while (cr.moveToNext()) {
            Course cs = new Course(cr.getString(0), cr.getString(1));
            list.add(cs);
        }
        return list;
    }

    public void addCourse(String idCs,String nameCs) {
        ContentValues values=new ContentValues();
        values.put(nameCourse,nameCs);
        values.put(idCourse,idCs);
        this.getWritableDatabase().insert(tbCourse,null,values);
    }
    public void deleteCourse(String idCs) {
        String query=idCourse+"=?";
        this.getWritableDatabase().delete(tbCourse,query,new String []{idCs});
    }
    public void updateCourse(String idCs,String name) {
        ContentValues values=new ContentValues();
        values.put(nameCourse,name);
        String query=idCourse+"=?";
        this.getWritableDatabase().update(tbCourse,values,query,new String []{idCs});
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
