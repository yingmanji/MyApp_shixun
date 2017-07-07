package com.example.a0_0.myapp_shixun;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.a0_0.myapp_shixun.fragment.FaxianFragment;
import com.example.a0_0.myapp_shixun.fragment.TongxunFragment;
import com.example.a0_0.myapp_shixun.fragment.WeixinFragment;
import com.example.a0_0.myapp_shixun.fragment.WodeFragment;
import com.example.a0_0.myapp_shixun.login.LoginActivity;
import com.example.a0_0.myapp_shixun.sqlite.model.User;

public class MainActivity extends Activity implements RadioGroup.OnCheckedChangeListener{
    private WeixinFragment weixinFragment;
    private TongxunFragment tongxunFragment;
    private FaxianFragment faxianFragment;
    private WodeFragment wodeFragment;

    private RadioGroup rg;

    private TextView tv_main_username;
    private String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_main_username=(TextView)findViewById(R.id.tv_main_username);

        Bundle bundle=this.getIntent().getExtras();
        //获取登录后的用户名
        if(bundle!=null) {
            username = bundle.getString("username");
            tv_main_username.setText("欢迎您"+username);
        }

        //第一次运行,默认需要登录
        if(username==null){
            Intent intent=new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            //如果没有finish(),点了返回键,会回到一个原始的MainActivity
            finish();
        }

        weixinFragment=new WeixinFragment();
        getFragmentManager().beginTransaction().replace(R.id.fl,weixinFragment).commit();

        rg=(RadioGroup)findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction=getFragmentManager().beginTransaction();
        if(checkedId==R.id.rb_wx){
            if(null==weixinFragment){
                weixinFragment=new WeixinFragment();
            }
            transaction.replace(R.id.fl,weixinFragment);
        }
        else if(checkedId==R.id.rb_tx){
            if(null==tongxunFragment){
                tongxunFragment=new TongxunFragment();
            }
            transaction.replace(R.id.fl,tongxunFragment);
        }
        else if(checkedId==R.id.rb_fx){
            if(null==faxianFragment){
                faxianFragment=new FaxianFragment();
            }
            transaction.replace(R.id.fl,faxianFragment);
        }
        else if(checkedId==R.id.rb_wd){
            if(null==wodeFragment){
                wodeFragment=new WodeFragment();
            }
            transaction.replace(R.id.fl,wodeFragment);
        }
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_actionbar,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
