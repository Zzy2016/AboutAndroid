package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import com.luozm.captcha.Captcha;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {


    VerifyView verifyView;
    SeekBar seekBar;
    LinearLayout llNotice;

    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyView.setVisibility(View.VISIBLE);
                seekBar.setVisibility(View.VISIBLE);
            }
        });

        verifyView = (VerifyView) findViewById(R.id.verify1);
        verifyView.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.back));


        llNotice = (LinearLayout) findViewById(R.id.llNotice);
        seekBar = (SeekBar) findViewById(R.id.seekBar1);
        seekBar.setMax(10000);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO 自动生成的方法存根
                verifyView.setMove(progress * 0.0001);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO 自动生成的方法存根

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO 自动生成的方法存根

            }

        });
        seekBar.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO 自动生成的方法存根
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP:
                        boolean isTrue = verifyView.isTrue(0.02);//允许有2%误差
                        if (isTrue) {
//                            showToast("验证成功");
                            llNotice.setVisibility(View.VISIBLE);
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    verifyView.setVisibility(View.GONE);
                                    seekBar.setVisibility(View.GONE);
                                }
                            }, 300);
                        }
                        break;
                }
                return false;
            }

        });


    }

    Toast toast;

    void showToast(String msg) {
        if (toast != null) toast.cancel();

        toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.show();
    }


}
