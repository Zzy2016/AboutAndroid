package com.example.aboutandroid;

import android.os.Bundle;

import com.example.aboutandroid.adapter.HomeListAdapter;
import com.example.aboutandroid.base.BaseActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends BaseActivity {

    private RecyclerView rvHomeList;
    private HomeListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new HomeListAdapter(MainActivity.this);
        rvHomeList = (RecyclerView) findViewById(R.id.rvHomeList);
        rvHomeList.setAdapter(adapter);
        rvHomeList.setLayoutManager(new LinearLayoutManager(this));

        dialog.show();

    }
}
