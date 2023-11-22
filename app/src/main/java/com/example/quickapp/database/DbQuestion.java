package com.example.quickapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.quickapp.models.Course;
import com.example.quickapp.models.Question;

import java.util.ArrayList;
import java.util.List;

public class DbQuestion extends DbTopic{
    public final String tbQuestion="tbQuestion";
    public final String idQuestion="idQuestion";
    public final String tilte="tilte";
    public final String correct="correct";

    public DbQuestion(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "QuickApp", factory, version);
    }
    public List<Question> getListQuestion() {
        List<Question> list = new ArrayList<>();
        String query = "select * from " + tbQuestion;
        Cursor cr = this.getReadableDatabase().rawQuery(query, null);
        while (cr.moveToNext()) {
            Question cs = new Question(cr.getString(0), cr.getString(1),cr.getString(2),cr.getString(3));
            list.add(cs);
        }
        return list;
    }

    public void addQuestion(String idCs,String nameCs,String crr,String idT) {
        ContentValues values=new ContentValues();
        values.put(tilte,nameCs);
        values.put(idQuestion,idCs);
        values.put(correct,crr);
        values.put(idTopic,idT);
        this.getWritableDatabase().insert(tbQuestion,null,values);
    }
    public void deleteQuestion(String idCs) {
        String query=idQuestion+"=?";
        this.getWritableDatabase().delete(tbQuestion,query,new String []{idCs});
    }
    public void updateQuestion(String idCs,String name,String crr) {
        ContentValues values=new ContentValues();
        values.put(tilte,name);
        values.put(correct,crr);
        String query=idQuestion+"=?";
        this.getWritableDatabase().update(tbQuestion,values,query,new String []{idCs});
    }

}
