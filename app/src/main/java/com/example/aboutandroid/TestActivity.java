package com.example.aboutandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.PagerTitleStrip;

import android.os.Bundle;

public class TestActivity extends AppCompatActivity {

    PagerTitleStrip pagerTitleStrip;

    PagerTabStrip pagerTabStrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        pagerTitleStrip = (PagerTitleStrip) findViewById(R.id.pagerTitleStrip);
    }
}
