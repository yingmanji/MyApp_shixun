package com.example.a0_0.myapp_shixun;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.a0_0.myapp_shixun.sqlite.model.User;
import com.example.a0_0.myapp_shixun.sqlite.DatabaseHelper;
import com.example.a0_0.myapp_shixun.sqlite.service.UserService;
import com.example.a0_0.myapp_shixun.sqlite.service.UserServiceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        //assertEquals("com.example.a0_0.myapp_shixun", appContext.getPackageName());

        System.out.println("##执行测试!");
        UserService userServiceImpl=new UserServiceImpl(appContext);
        userServiceImpl.getReadableDatabase();
        System.out.println("##"+userServiceImpl.getDatabaseName());

        User user=new User("1","1");

        long flag=userServiceImpl.add(user);
        if(flag>0){

            List<User> list=userServiceImpl.getAllUser();

            for(User u:list){
                System.out.println("#"+u);
            }

            System.out.println("#表插入数据成功!");
        }
        else {
            System.out.println("#表插入数据失败!");
        }


    }
}
