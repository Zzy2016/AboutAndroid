package com.example.aboutandroid;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.aboutandroid.base.BaseActivity;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class SoundsActivity extends BaseActivity {


    private LinearLayout llLeft;
    private TextView tvLeft, tvRight;
    private DrawerLayout dl;

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




    }


}
