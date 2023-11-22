package com.example.quickapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.quickapp.models.Account;
import com.example.quickapp.models.Course;

import java.util.ArrayList;
import java.util.List;

public class DbAccCount extends SQLiteOpenHelper {
public final String idMssv="IdMssv";
public final String nameCount="NameCount";
public final String pass="Pass";
public final String tbAccCount="tbAccCount";

    public DbAccCount(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "QuickApp", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTbCourse = "Create table tbCourse(idCourse text,nameCourse text)";
        sqLiteDatabase.execSQL(createTbCourse);

        String createTbTopic="Create table tbTopic(idTopic text primary key, nameTopic text, idCourse text)";
        sqLiteDatabase.execSQL(createTbTopic);

        String createTbQuestion="Create table tbQuestion(idQuestion text primary key, tilte text, correct text, idTopic text)";
        sqLiteDatabase.execSQL(createTbQuestion);

        String createTbAnswer="Create table tbAnswer(idAnswer text primary key, contentAnswer text, idQuestion text)";
        sqLiteDatabase.execSQL(createTbAnswer);

        String createTbStudent="Create table tbStudent(mssv text primary key, nameStudent text, idHistory text)";
        sqLiteDatabase.execSQL(createTbStudent);

        String createTbHistory="Create table tbHistory(idHistory text primary key, score text, finishTime text)";
        sqLiteDatabase.execSQL(createTbHistory);

        String createTbAccCount = "Create table " + tbAccCount + "(" +
                idMssv + " text, " +
                nameCount + " text," +
                pass+"text"+
                ")";
        sqLiteDatabase.execSQL(createTbAccCount);
    }
    public List<Account> getListAccount() {
        List<Account> list = new ArrayList<>();
        String query = "select * from " + tbAccCount;
        Cursor cr = this.getReadableDatabase().rawQuery(query, null);
        while (cr.moveToNext()) {
            Account ac = new Account(cr.getString(0), cr.getString(1),cr.getString(2));
            list.add(ac);
        }
        return list;
    }
    public void addAccount(String idmssv,String nameAcc,String pas) {
        String query = "insert into tbAccCount values(?,?,?)";
        this.getWritableDatabase().execSQL(query,new String[]{idmssv,nameAcc,pas});
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
