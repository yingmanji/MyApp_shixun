package com.example.a0_0.myapp_shixun.sqlite.service;

import android.database.sqlite.SQLiteDatabase;

import com.example.a0_0.myapp_shixun.sqlite.model.User;

import java.util.List;

/**
 * Created by 樱满集0_0 on 2017/6/27.
 */

public interface UserService {

    long add(User user);
    boolean getUserByName(String name);
    String getDatabaseName();
    SQLiteDatabase getReadableDatabase();
    SQLiteDatabase getWritableDatabase();
    String getPasswordByName(String name);
    List<User> getAllUser();
}
