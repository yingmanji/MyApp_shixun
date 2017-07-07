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
public class TongxunFragment extends Fragment implements AdapterView.OnItemClickListener{
    private static final String[] items1={"1","2","3"};
    private static final String[] items2={"张三","李四","王五"};
    private static final int[] imageId={R.mipmap.ic_launcher,R.mipmap.ic_launcher,
    R.mipmap.ic_launcher};
    private ListView lv_tx;

    List<Map<String,String>> list;

    public TongxunFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_tongxun,null);

        lv_tx=(ListView)view.findViewById(R.id.lv_tx);

        list=new ArrayList<>();

        for(int i=0;i<items1.length;i++){
            Map<String,String> map=new HashMap<>();
            map.put("img",String.valueOf(imageId[i]));
            map.put("tv1",items1[i]);
            map.put("tv2",items2[i]);
            list.add(map);
        }

        String[] from={"img","tv1","tv2"};
        int[] to={R.id.iv,R.id.tv_1,R.id.tv_2};


        SimpleAdapter simpleAdapter=new SimpleAdapter(view.getContext(),list,R.layout.menu_tx,from,to);

        lv_tx.setAdapter(simpleAdapter);

        lv_tx.setOnItemClickListener(this);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(getActivity(), Activity_chat.class);
        intent.putExtra("String",items2[position]+":");
        startActivity(intent);
    }
}
