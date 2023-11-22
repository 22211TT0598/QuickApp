package com.example.quickapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.quickapp.models.Answer;
import com.example.quickapp.models.Course;

import java.util.ArrayList;
import java.util.List;

public class DbAnswer extends DbQuestion{
    public final String tbAnswer="tbAnswer";
    public final String idAnswer="idAnswer";
    public final String contentAnswer="contentAnswer";

    public DbAnswer(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "QuickApp", factory, version);
    }
    public List<Answer> getListAnswer() {
        List<Answer> list = new ArrayList<>();
        String query = "select * from " + tbAnswer;
        Cursor cr = this.getReadableDatabase().rawQuery(query, null);
        while (cr.moveToNext()) {
            Answer cs = new Answer(cr.getString(0), cr.getString(1),cr.getString(2));
            list.add(cs);
        }
        return list;
    }

    public void addAnswer(String idCs,String nameCs,String idQ) {
        ContentValues values=new ContentValues();
        values.put(idAnswer,idCs);
        values.put(contentAnswer,nameCs);
        values.put(idQuestion,idQ);
        this.getWritableDatabase().insert(tbAnswer,null,values);
    }
    public void deleteAnswer(String idCs) {
        String query=idAnswer+"=?";
        this.getWritableDatabase().delete(tbAnswer,query,new String []{idCs});
    }
    public void updateAnswer(String idCs,String name) {
        ContentValues values=new ContentValues();
        values.put(contentAnswer,name);
        String query=idAnswer+"=?";
        this.getWritableDatabase().update(tbAnswer,values,query,new String []{idCs});
    }
}
