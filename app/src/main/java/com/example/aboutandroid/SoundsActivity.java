package com.example.aboutandroid;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aboutandroid.base.BaseActivity;
import com.google.android.material.tabs.TabLayout;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class SoundsActivity extends BaseActivity {


    private LinearLayout llLeft;
    private TextView tvLeft, tvRight;
    private DrawerLayout dl;
    private TextView tvMenu;

    private TabLayout tabLayout;
    private TextView tvSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sounds);

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


    public void initView(){
        tvMenu=(TextView)findViewById(R.id.tvMenu);
        dl=(DrawerLayout)findViewById(R.id.dl);

        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        tvSearch=(TextView)findViewById(R.id.tvSearch);
        tvMenu.setOnClickListener(new View.OnClickListener() {
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
                Toast.makeText(SoundsActivity.this,"search",Toast.LENGTH_LONG).show();
            }
        });

    }

}
