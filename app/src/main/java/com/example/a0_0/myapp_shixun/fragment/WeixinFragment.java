package com.example.a0_0.myapp_shixun.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.a0_0.myapp_shixun.R;
import com.example.a0_0.myapp_shixun.activity.Activity_chat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class WeixinFragment extends Fragment implements AdapterView.OnItemClickListener{
    private static final String[] items1={"1","2","3"};
    private static final String[] items2={"你有一条新消息","有人@你哦","大事情@所有人"};
    private static final int[] imageId={R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};

    private ListView lv_wx;

    List<Map<String,String>> list;

    public WeixinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        list=new ArrayList<>();

        for(int i=0;i<items1.length;i++){
            Map<String,String> map=new HashMap<>();
            map.put("img",String.valueOf(imageId[i]));
            map.put("tv1",String.valueOf(items1[i]));
            map.put("tv2",String.valueOf(items2[i]));
            list.add(map);
        }

        //这里要获取视图,后面两个参数直接改为null
        View view=inflater.inflate(R.layout.fragment_weixin,null);

        String[] from={"img","tv1","tv2"};
        int[] to={R.id.iv,R.id.tv_1,R.id.tv_2};

        //注意第一个参数是getActivity()
        SimpleAdapter simpleAdapter=new SimpleAdapter(getActivity(),list,R.layout.menu,from,to);

        lv_wx=(ListView)view.findViewById(R.id.lv_wx);
        lv_wx.setAdapter(simpleAdapter);

        lv_wx.setOnItemClickListener(this);


        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(getActivity(), Activity_chat.class);
        intent.putExtra("String",items2[position]);
        startActivity(intent);
    }
}
