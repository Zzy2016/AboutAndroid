package com.example.aboutandroid.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.aboutandroid.R;
import com.example.aboutandroid.fragment.ControlBarFragment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;

import static android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
import static android.view.WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS;

/**
 * @author: Administrator
 * @date: 2020-07-16
 */
public class BaseActivity extends AppCompatActivity {


    protected Dialog dialog;

    private Context context;


    private ControlBarFragment controlBarFragment;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //4.0
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        //5.0-6.0
        getWindow().addFlags(FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, android.R.color.transparent));


        getWindow().getDecorView().setSystemUiVisibility(SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);


        context = this;
        initDialog();

        showControlBar(true);



    }

    public void initDialog() {
        dialog = new Dialog(this);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog1, null);
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setTitle("ceshi");

        Window window = dialog.getWindow();
        window.setBackgroundDrawableResource(android.R.color.transparent);
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        layoutParams.width = (int) (display.getWidth() * 0.7);
        layoutParams.height = (int) (display.getHeight() * 0.3);
        window.setAttributes(layoutParams);
    }


    public void showControlBar(boolean show) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (show) {
            if (controlBarFragment == null) {
                controlBarFragment = new ControlBarFragment();
                ft.add(R.id.bottom_container, controlBarFragment).commitAllowingStateLoss();
            } else {
                ft.show(controlBarFragment).commitAllowingStateLoss();
            }
        } else {
            if (controlBarFragment != null) {
                ft.hide(controlBarFragment).commitAllowingStateLoss();
            }
        }

    }




}
