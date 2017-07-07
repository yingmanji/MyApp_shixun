package com.example.a0_0.myapp_shixun.login;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a0_0.myapp_shixun.MainActivity;
import com.example.a0_0.myapp_shixun.R;
import com.example.a0_0.myapp_shixun.register.RegisterActivity;
import com.example.a0_0.myapp_shixun.sqlite.model.User;
import com.example.a0_0.myapp_shixun.sqlite.service.UserService;
import com.example.a0_0.myapp_shixun.sqlite.service.UserServiceImpl;

import java.util.List;

public class LoginActivity extends Activity {

    private String username;
    private String password;

    private EditText login_et_username;
    private EditText login_et_password;
    private Button login_btn_register;
    private Button login_btn_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_et_username=(EditText)findViewById(R.id.login_et_username);
        login_et_password=(EditText)findViewById(R.id.login_et_password);
        login_btn_register=(Button)findViewById(R.id.login_btn_register);
        login_btn_login=(Button)findViewById(R.id.login_btn_login);


    }
    public void login(View view){
        username=login_et_username.getText().toString();
        password=login_et_password.getText().toString();
        UserService userServiceImpl=new UserServiceImpl(view.getContext());
        userServiceImpl.getReadableDatabase();
        System.out.println("#"+userServiceImpl.getDatabaseName());

        String text=username+password;
        //Toast.makeText(view.getContext(),text,Toast.LENGTH_SHORT).show();
        if(username.equals("")&&password.equals(""))
        {
            Toast.makeText(view.getContext(),"用户名和密码不能为空",Toast.LENGTH_SHORT).show();
        }
        else {
            List<User> list=userServiceImpl.getAllUser();

            for(User u:list){
                System.out.println("#"+u);
            }

            if (userServiceImpl.getUserByName(username)) {

                if(password.equals(userServiceImpl.getPasswordByName(username))) {
                    //Toast.makeText(LoginActivity.this, "欢迎您" + username, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, MainActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("username", username);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(LoginActivity.this,"密码错误,请核对后再尝试",Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(LoginActivity.this, "用户不存在", Toast.LENGTH_SHORT).show();
            }
        }


    }
    public void register(View view){
        Intent intent=new Intent(this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }
}
