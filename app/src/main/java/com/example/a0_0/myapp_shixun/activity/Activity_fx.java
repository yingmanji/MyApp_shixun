package com.example.a0_0.myapp_shixun.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.a0_0.myapp_shixun.R;

public class Activity_fx extends Activity {
    private TextView tv_activity_fx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fx);

        Intent intent=getIntent();

        tv_activity_fx=(TextView)findViewById(R.id.tv_activity_fx);

        tv_activity_fx.setText(intent.getStringExtra("String")+"\n");
    }
}
