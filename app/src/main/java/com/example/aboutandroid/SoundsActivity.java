package com.example.aboutandroid;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aboutandroid.base.BaseActivity;
import com.example.aboutandroid.bean.Sound;
import com.example.aboutandroid.databinding.ActivitySoundsBinding;
import com.google.android.material.tabs.TabLayout;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class SoundsActivity extends BaseActivity implements View.OnClickListener {


    private LinearLayout llLeft;
    private TextView tvLeft, tvRight;
    private DrawerLayout dl;
    private TextView tvMenu;

    private TabLayout tabLayout;
    private TextView tvSearch;


    private ActivitySoundsBinding bind;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bind = ActivitySoundsBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
//        setContentView(R.layout.activity_sounds);

//        llLeft = (LinearLayout) findViewById(R.id.llLeft);

//        tvLeft = (TextView) findViewById(R.id.tvLeft);
//        tvRight = (TextView) findViewById(R.id.tvRight);
//        dl = (DrawerLayout) findViewById(R.id.dl);
//
//        tvLeft.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dl.openDrawer(GravityCompat.START);
//            }
//        });


        initView();

    }


    public void initView() {
        tvMenu = (TextView) findViewById(R.id.tvMenu);
        dl = (DrawerLayout) findViewById(R.id.dl);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tvSearch = (TextView) findViewById(R.id.tvSearch);
        bind.tvMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dl.openDrawer(GravityCompat.START);
            }
        });

        tabLayout.addTab(tabLayout.newTab().setText("测试1"));
        tabLayout.addTab(tabLayout.newTab().setText("测试2"));

        tvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SoundsActivity.this, "search", Toast.LENGTH_LONG).show();
            }
        });


        bind.tvMenuItem1.setOnClickListener(this);
        bind.tvMenuItem2.setOnClickListener(this);
        bind.tvMenuItem3.setOnClickListener(this);
        bind.tvMenuItem4.setOnClickListener(this);
        bind.tvMenuItem5.setOnClickListener(this);

        bind.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {


            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getText().toString().equals("测试1")) {

                    bind.dl.setBackgroundColor(getResources().getColor(R.color.blue));
                    Toast.makeText(SoundsActivity.this, "测试1", Toast.LENGTH_SHORT).show();
                } else {

                    bind.dl.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    Toast.makeText(SoundsActivity.this, "测试2", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    @Override
    public void onClick(View v) {
        bind.dl.closeDrawer(GravityCompat.START);
//        switch (v.getId()) {
//            case R.id.tvMenuItem1:
//
//                break;
//            case R.id.tvMenuItem2:
//
//                break;
//            case R.id.tvMenuItem3:
//
//                break;
//            case R.id.tvMenuItem4:
//
//                break;
//            case R.id.tvMenuItem5:
//
//                break;
//
//        }
    }
}
