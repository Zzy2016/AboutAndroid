package com.example.aboutandroid;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.aboutandroid.adapter.HomeListAdapter;

public class MainActivity extends AppCompatActivity {

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


    }
}
