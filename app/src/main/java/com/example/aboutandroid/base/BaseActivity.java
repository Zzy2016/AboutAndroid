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

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author: Administrator
 * @date: 2020-07-16
 */
public class BaseActivity extends AppCompatActivity {


    protected Dialog dialog;

    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        initDialog();
    }

    public void initDialog() {
        dialog = new Dialog(this, R.style.SampleThemeLight);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog1, null);
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setTitle("ceshi");

        Window window = dialog.getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        layoutParams.width = (int) (display.getWidth() * 0.7);
        layoutParams.height = (int) (display.getHeight() * 0.3);
        window.setAttributes(layoutParams);
    }

}
