package com.example.aboutandroid.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aboutandroid.adapter.LastSoundAdapter;
import com.example.aboutandroid.bean.LastSound;
import com.example.aboutandroid.databinding.FragmentItem1Binding;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import retrofit2.Retrofit;

public class ItemFragment1 extends Fragment {


    private FragmentItem1Binding binding;
    private LastSoundAdapter adapter;
    private List<LastSound> lastSoundList;
    private Gson gson;
    private Retrofit retrofit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lastSoundList = new ArrayList<>();
        adapter = new LastSoundAdapter(lastSoundList, getContext());
//        retrofit = new Retrofit.Builder().baseUrl(Constant.baseUrl).addCallAdapterFactory().addConverterFactory().build();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentItem1Binding.inflate(getLayoutInflater(), container, false);
        initView();
//        return inflater.inflate(R.layout.fragment_item1, container, false);
        return binding.getRoot();
    }


    public void initView() {
//        binding.recyclerView.setBackgroundColor(getResources().getColor(R.color.red));
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL));


    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            Log.e("-------------", "itemFragment1");
        }
    }
}
