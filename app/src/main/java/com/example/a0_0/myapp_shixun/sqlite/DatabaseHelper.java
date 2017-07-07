package com.example.a0_0.myapp_shixun.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.a0_0.myapp_shixun.sqlite.model.User;

/**
 * Created by 樱满集0_0 on 2017/6/25.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME="mydb_user.db";
    public static final String TB_NAME="user";
    public static final int DB_VERSION=1;
    public static final String USER_ID="userId";
    public static final String USER_NAME="userName";
    public static final String USER_PASSWORD="userPassword";
    public static final String SQL="create table "+TB_NAME+"("+
            USER_ID+" integer primary key autoincrement,"+
            USER_NAME+" text,"+
            USER_PASSWORD+" text"+
            ")";

    //使用单例模式
    private static DatabaseHelper instance;
    public static DatabaseHelper getInstance(Context context){
        if(null==instance){
            instance=new DatabaseHelper(context);
        }
        return instance;
    }

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("#执行onCreate方法");
        try {
            db.execSQL(SQL);
            System.out.println("#表创建成功");
        }
        catch (Exception e){
            System.out.println("#表创建失败!");
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
