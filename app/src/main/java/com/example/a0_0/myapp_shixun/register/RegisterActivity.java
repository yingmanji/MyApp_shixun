package com.example.a0_0.myapp_shixun.register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a0_0.myapp_shixun.R;
import com.example.a0_0.myapp_shixun.login.LoginActivity;
import com.example.a0_0.myapp_shixun.sqlite.model.User;
import com.example.a0_0.myapp_shixun.sqlite.DatabaseHelper;
import com.example.a0_0.myapp_shixun.sqlite.service.UserService;
import com.example.a0_0.myapp_shixun.sqlite.service.UserServiceImpl;

import java.util.List;

public class RegisterActivity extends Activity {
    private String username;
    private String password;
    private String checkPassword;

    private EditText register_et_username;
    private EditText register_et_password;
    private EditText register_et_checkPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register_et_username=(EditText)findViewById(R.id.register_et_username);
        register_et_password=(EditText)findViewById(R.id.register_et_password);
        register_et_checkPassword=(EditText)findViewById(R.id.register_et_checkPassword);


    }
    //注册
    public void register(View view){

        username=register_et_username.getText().toString();
        password=register_et_password.getText().toString();
        checkPassword=register_et_checkPassword.getText().toString();

        /*DatabaseHelper helper=DatabaseHelper.getInstance(this);
        helper.getReadableDatabase();*/
        UserService userServiceImpl=new UserServiceImpl(view.getContext());

        userServiceImpl.getReadableDatabase();

        System.out.println("##mainActivity执行onCreate方法");

        System.out.println("##"+userServiceImpl.getDatabaseName());

        if(username.equals("")|password.equals("")){
            Toast.makeText(RegisterActivity.this,"用户名或密码不能为空",Toast.LENGTH_SHORT).show();
        }
        else if(userServiceImpl.getUserByName(username)) {
            Toast.makeText(RegisterActivity.this,"用户名已被注册",Toast.LENGTH_SHORT).show();
        }
        else {
            if(!(checkPassword.equals(password))){
                Toast.makeText(this,"两次输入的密码不一致",Toast.LENGTH_SHORT).show();
            }
            else {
                User user = new User(username, password);
                System.out.println("#" + user.getUserName() + user.getUserPassword());


                Long flag = userServiceImpl.add(user);
                if (flag > 0) {
                    List<User> list = userServiceImpl.getAllUser();

                    for (User u : list) {
                        System.out.println("#" + u);
                    }
                    System.out.println("#mainActivity表数据插入成功!");
                } else {
                    System.out.println("#mainActivity表数据插入失败!");
                }


                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            }
        }

    }
    //取消
    public void cancel(View view){
        startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
    }
}
