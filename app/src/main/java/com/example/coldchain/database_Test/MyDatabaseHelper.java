package com.example.coldchain.database_Test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context mContext;

    public static final String Domestic_user="create table domestic_user ("
            +"id integer primary key autoincrement,"
            +"name text,"
            +"password text)";

    public static final String Transport_user="create table transport_user ("
            +"id integer primary key autoincrement,"
            +"name text,"
            +"password text)";


    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Domestic_user);
        Toast.makeText(mContext, "user_table创建成功！", Toast.LENGTH_SHORT).show();
        db.execSQL(Transport_user);
        Toast.makeText(mContext, "transport_user创建成功！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
