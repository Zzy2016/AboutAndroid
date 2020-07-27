package com.example.aboutandroid.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.aboutandroid.R;
import com.example.aboutandroid.base.BaseActivity;
import com.example.aboutandroid.databinding.ActivitySoundsBinding;
import com.example.aboutandroid.fragment.ListFragment;
import com.example.aboutandroid.fragment.MenuFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SoundsActivity extends BaseActivity implements View.OnClickListener {


    private DrawerLayout dl;
    private TabLayout tabLayout;
    private ActivitySoundsBinding bind;
    private List<Fragment> fragmentList;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bind = ActivitySoundsBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
        fragmentList = new ArrayList<>();
        fragmentList.add(new MenuFragment());
        fragmentList.add(new ListFragment());
        customAdapter = new CustomAdapter(getSupportFragmentManager());
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

        bind.vp.setAdapter(customAdapter);
        tabLayout.setupWithViewPager(bind.vp,false);

    }


    @Override
    public void onClick(View v) {
        bind.dl.closeDrawer(GravityCompat.START);
        switch (v.getId()) {
            case R.id.tvMenuItem1:
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

    public class CustomAdapter extends FragmentPagerAdapter {

        public CustomAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return getResources().getStringArray(R.array.titles)[position];
        }
    }


}
