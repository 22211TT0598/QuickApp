package com.example.quickapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.quickapp.models.History;

import java.util.ArrayList;
import java.util.List;

public class DbHistory extends DbCourse{
    public final String tbHistory="tbHistory";
    public final String idHistory="idHistory";
    public final String score="score";
    public final String finishTime="finishTime";
    public DbHistory(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "QuickApp", factory, version);
    }
    public List<History> getListHistory() {
        List<History> list = new ArrayList<>();
        String query = "select * from " + tbHistory;
        Cursor cr = this.getReadableDatabase().rawQuery(query, null);
        while (cr.moveToNext()) {
            History history = new History(cr.getString(0), cr.getString(1),cr.getString(2));
            list.add(history);
        }
        return list;
    }

    public void addHistory(String idCs,String ft,String sc,String idSt) {
        ContentValues values=new ContentValues();
        values.put(finishTime,ft);
        values.put(idHistory,idCs);
        values.put(score,sc);
        this.getWritableDatabase().insert(tbHistory,null,values);
    }
    public void deleteHistory(String idCs) {
        String query=idHistory+"=?";
        this.getWritableDatabase().delete(tbHistory,query,new String []{idCs});
    }
//    public List<History> searchHistory(String idSt) {
//        List<History> list = new ArrayList<>();
//        String query ="select * from '"+ tbHistory+"'where '"+ mssv+"' =?";
//
//        Cursor cr = this.getReadableDatabase().rawQuery(query, new String[]{idSt});
//        while (cr.moveToNext()) {
//            History history = new History(cr.getString(0), cr.getString(1),cr.getString(2),cr.getString(3));
//            list.add(history);
//        }
//        return list;
//    }
}
