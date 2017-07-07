package com.example.a0_0.myapp_shixun.fragment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.a0_0.myapp_shixun.R;
import com.example.a0_0.myapp_shixun.activity.Activity_chat;
import com.example.a0_0.myapp_shixun.activity.Activity_fx;

/**
 * A simple {@link Fragment} subclass.
 */
public class FaxianFragment extends Fragment implements AdapterView.OnItemClickListener{
    private ListView lv_fx;

    private static final String[] items={"震惊！你身边的这个东西一直在影响你的身体","你不知道的十个健康的生活习惯"
    ,"男人看了沉默,女人看了流泪..."};

    public FaxianFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_faxian,null);

        lv_fx=(ListView)view.findViewById(R.id.lv_fx);

        ArrayAdapter arrayAdapter=new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,items);

        lv_fx.setAdapter(arrayAdapter);

        lv_fx.setOnItemClickListener(this);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(getActivity(), Activity_fx.class);
        intent.putExtra("String",items[position]);
        startActivity(intent);
    }
}
