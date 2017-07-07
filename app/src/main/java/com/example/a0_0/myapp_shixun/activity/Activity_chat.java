package com.example.a0_0.myapp_shixun.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a0_0.myapp_shixun.R;

public class Activity_chat extends Activity {
    private TextView tv_chat;
    private AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        tv_chat=(TextView)findViewById(R.id.tv_chat);
        autoCompleteTextView=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);

        Intent intent=getIntent();
        tv_chat.setText(intent.getStringExtra("String"));
    }
    public void send(View view){
        if(autoCompleteTextView.getText().equals("")){
            Toast.makeText(this,"输入不能为空",Toast.LENGTH_SHORT).show();
        }
        else {
            tv_chat.setText(tv_chat.getText()+"\n"+autoCompleteTextView.getText()+"\n");
        }
    }
}
