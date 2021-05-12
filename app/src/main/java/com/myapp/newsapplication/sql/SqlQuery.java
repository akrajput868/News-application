package com.myapp.newsapplication.sql;

import android.content.Context;

public class SqlQuery {

    Sqlhelper sql;
    private Context con;

    public SqlQuery(Context con) {
        this.con = con;
        sql=new Sqlhelper(con);
    }

}
