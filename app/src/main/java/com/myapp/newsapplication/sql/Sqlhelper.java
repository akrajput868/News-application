package com.myapp.newsapplication.sql;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class Sqlhelper extends SQLiteOpenHelper {

    private static String name = "USRE_details";
    private static SQLiteDatabase.CursorFactory factory=null;
    private static int version=1;

    public Sqlhelper(Context context) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase obj) {
        String tableUser = "create table user (id integer not null primary key autoincrement, name text, phone text, email text, address text)";
        obj.execSQL(tableUser);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS user");
        onCreate(sqLiteDatabase);

    }
}
