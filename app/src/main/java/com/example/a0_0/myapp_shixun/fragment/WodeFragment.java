package com.example.a0_0.myapp_shixun.fragment;


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
import com.example.a0_0.myapp_shixun.login.LoginActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class WodeFragment extends Fragment implements AdapterView.OnItemClickListener{
    private ListView lv_wd;

    private static final String[] items={"重新登录"};

    public WodeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_wode,null);

        lv_wd=(ListView) view.findViewById(R.id.lv_wd);

        lv_wd.setAdapter(new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,items));

        lv_wd.setOnItemClickListener(this);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }
}
