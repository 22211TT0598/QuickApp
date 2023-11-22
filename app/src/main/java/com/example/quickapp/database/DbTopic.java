package com.example.quickapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.quickapp.models.Course;
import com.example.quickapp.models.Topic;

import java.util.ArrayList;
import java.util.List;

public class DbTopic extends DbCourse {
    public final  String idTopic= "idTopic";
    public  final String tbTopic="tbTopic";
    public final  String nameTopic= "nameTopic";

    public DbTopic(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "QuickApp", factory, version);
    }


    public List<Topic> getListTopic() {
        List<Topic> list = new ArrayList<>();
        String query = "select * from " + tbTopic;
        Cursor cr = this.getReadableDatabase().rawQuery(query, null);
        while (cr.moveToNext()) {
            Topic cs = new Topic(cr.getString(0), cr.getString(1),cr.getString(2));
            list.add(cs);
        }
        return list;
    }

    public void addTopic(String idT,String nameCs,String idC) {
        ContentValues values=new ContentValues();
        values.put(idTopic,idT);
        values.put(nameTopic,nameCs);
        values.put(idCourse,idC);
        this.getWritableDatabase().insert(tbTopic,null,values);
    }
    public void deleteTopic(String idCs) {
        String query=idTopic+"=?";
        this.getWritableDatabase().delete(tbTopic,query,new String []{idCs});
    }
    public void updateTopic(String idCs,String name) {
        ContentValues values=new ContentValues();
        values.put(nameTopic,name);
        String query=idTopic+"=?";
        this.getWritableDatabase().update(tbTopic,values,query,new String []{idCs});
    }

}
