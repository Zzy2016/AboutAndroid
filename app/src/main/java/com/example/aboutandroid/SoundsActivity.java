package com.example.aboutandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aboutandroid.base.BaseActivity;
import com.example.aboutandroid.databinding.ActivitySoundsBinding;
import com.example.aboutandroid.util.SharedPreferencesUtil;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class SoundsActivity extends BaseActivity implements View.OnClickListener {


    private DrawerLayout dl;
    private TabLayout tabLayout;


    private ActivitySoundsBinding bind;

    private boolean isNight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        isNight=SharedPreferencesUtil.putData("isNight", true);// true 夜间  false日间
        bind = ActivitySoundsBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        initView();

    }


    public void initView() {

        dl = (DrawerLayout) findViewById(R.id.dl);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        bind.tvMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                switchMode();
                dl.openDrawer(GravityCompat.START);
            }
        });

        for (int i = 0; i < getResources().getStringArray(R.array.titles).length; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(getResources().getStringArray(R.array.titles)[i]));
        }


        bind.tvSearch.setOnClickListener(new View.OnClickListener() {
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
                switch (tab.getText().toString()) {
                    case "我的":
                        bind.dl.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                        break;
                    case "发现":
                        bind.dl.setBackgroundColor(getResources().getColor(R.color.blue));
                        break;
                    case "云村":
                        bind.dl.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                        break;
                    case "视频":
                        bind.dl.setBackgroundColor(getResources().getColor(R.color.blue));
                        break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

//        switchMode();
    }


    @Override
    public void onClick(View v) {
        bind.dl.closeDrawer(GravityCompat.START);
        switch (v.getId()) {
            case R.id.tvMenuItem1:

//                if (bind.tvMenuItem1.getText().toString().equals("夜间模式")) {
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//                    SharedPreferencesUtil.getData("isNight", false);
//                    bind.tvMenuItem1.setText("日间模式");
//                } else {
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//                    SharedPreferencesUtil.getData("isNight", true);
//                    bind.tvMenuItem1.setText("夜间模式");
//                }
//                if(isNight){
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//                    recreate();
//                }else {
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//                    recreate();
//                }

                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                recreate();

                break;
            case R.id.tvMenuItem2:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                recreate();
                break;
            case R.id.tvMenuItem3:

                break;
            case R.id.tvMenuItem4:

                break;
            case R.id.tvMenuItem5:

                break;

        }
    }

//    public void switchMode(){
//        if(isNight){
//            bind.tvMenuItem1.setText("日间模式");
//        }else {
//            bind.tvMenuItem1.setText("夜间模式");
//        }
//    }
}
