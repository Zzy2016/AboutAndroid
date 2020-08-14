package com.example.aboutandroid.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSONObject;
import com.example.aboutandroid.R;
import com.example.aboutandroid.TopModel;
import com.example.aboutandroid.adapter.TopAdapter;
import com.example.aboutandroid.util.util;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class ItemFragment3 extends Fragment {

    private RecyclerView rvTop;
    private TopAdapter topAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item3, container, false);
        initView(view);
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            Log.e("-------------", "itemFragment3");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void initView(View view) {
        rvTop = view.findViewById(R.id.rvTop);
        TopModel topModel = JSONObject.parseObject(util.getOriginalFundData(getContext()), TopModel.class);
        topAdapter = new TopAdapter(topModel.getSong_list(), getContext());
        rvTop.setAdapter(topAdapter);
//        rvTop.setLayoutManager(new GridLayoutManager(getContext(), 3));

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rvTop.setLayoutManager(staggeredGridLayoutManager);
    }
}
