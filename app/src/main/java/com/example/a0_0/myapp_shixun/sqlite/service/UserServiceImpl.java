package com.example.a0_0.myapp_shixun.sqlite.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.a0_0.myapp_shixun.sqlite.DatabaseHelper;
import com.example.a0_0.myapp_shixun.sqlite.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 樱满集0_0 on 2017/6/27.
 */

public class UserServiceImpl implements UserService{

    private DatabaseHelper databaseHelper;

    public UserServiceImpl(Context context){
        databaseHelper=DatabaseHelper.getInstance(context);
    }

    public long add(User user){
        SQLiteDatabase db=databaseHelper.getReadableDatabase();

        ContentValues values=new ContentValues();
        values.put(DatabaseHelper.USER_NAME,user.getUserName());
        values.put(DatabaseHelper.USER_PASSWORD,user.getUserPassword());

        long flag=db.insert(DatabaseHelper.TB_NAME,null,values);

        return flag;
    }

    public boolean getUserByName(String name){

        SQLiteDatabase db=databaseHelper.getReadableDatabase();
        boolean flag=false;
        Cursor cursor=null;

        try {
            //该方法第一个参数是表名,第二个参数要查询到的结果,第三个参数where条件,第四个参数通过形参填入参数,
            //后面是Order By GROUP BY那些条件
            cursor=db.query(DatabaseHelper.TB_NAME,new String[]{DatabaseHelper.USER_ID
                    ,DatabaseHelper.USER_NAME,DatabaseHelper.USER_PASSWORD},DatabaseHelper.USER_NAME+"=?",new String[]{name},null,null,null);
            /*cursor = db.rawQuery("select * from " + databaseHelper.TB_NAME + " where"+databaseHelper.USER_NAME
                    +"="+name,
                    null);*/
            System.out.println("#cursor"+String.valueOf(cursor.getCount()));
            if(cursor.moveToNext()){
                flag=true;
                System.out.println("#成功查询到该用户");
            }
            else
            {
                flag=false;
                System.out.println("#查询不到该用户");
            }

        }
        catch (Exception e){
            System.out.println("#查询用户名错误");
        }
        finally {
            if(null==cursor) {
                cursor.close();
            }
        }
        return flag;
    }
    public String getPasswordByName(String name){
        SQLiteDatabase db=databaseHelper.getReadableDatabase();
        String password="";

        Cursor cursor=null;
        try {
            cursor=db.query(DatabaseHelper.TB_NAME,new String[]{DatabaseHelper.USER_ID
                    ,DatabaseHelper.USER_NAME,DatabaseHelper.USER_PASSWORD},DatabaseHelper.USER_NAME+"=?",new String[]{name},null,null,null);
            System.out.println("#getPasswordByName"+String.valueOf(cursor.getCount()));
            System.out.println("#getPasswordByName"+String.valueOf(cursor.moveToFirst()));
            if(cursor!=null&&cursor.moveToFirst()){
                do {
                password=cursor.getString(cursor.getColumnIndex(DatabaseHelper.USER_PASSWORD));
                System.out.println("#查询用户密码成功"+password);
                }
                while (cursor.moveToNext());
            }
            else {
                System.out.println("#查询不到该用户密码");
            }
        }
        catch (Exception e){
            System.out.println("#查询密码错误");
        }
        finally {
            cursor.close();
        }
        return password;
    }
    public String getDatabaseName(){
        return databaseHelper.getDatabaseName();
    }
    public SQLiteDatabase getReadableDatabase(){
        return databaseHelper.getReadableDatabase();
    }
    public SQLiteDatabase getWritableDatabase(){
        return databaseHelper.getWritableDatabase();
    }
    public List<User> getAllUser(){
        List<User> list=new ArrayList<>();

        SQLiteDatabase db=databaseHelper.getReadableDatabase();
        Cursor cursor=null;



        try {
            cursor=db.rawQuery("select * from "+DatabaseHelper.TB_NAME,null);

            if (null != cursor && cursor.moveToFirst()) {
                do {
                    User user = new User();
                    user.setUserId(cursor.getInt(cursor.getColumnIndex(databaseHelper.USER_ID)));
                    user.setUserName(cursor.getString(cursor.getColumnIndex(databaseHelper.USER_NAME)));
                    user.setUserPassword(cursor.getString(cursor.getColumnIndex(databaseHelper.USER_PASSWORD)));
                    list.add(user);
                }
                while (cursor.moveToNext());
            }
            else
            {
                System.out.println("#表里没有数据");
            }
        }
        catch (Exception e){
            System.out.println("#获取用户所有数据失败");
        }
        finally{
            if(null==cursor){
                cursor.close();
            }
        }
        return list;
    }
}
