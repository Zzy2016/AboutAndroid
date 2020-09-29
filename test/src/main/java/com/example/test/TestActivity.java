package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class TestActivity extends Activity {


    VerifyView verifyView;
    SeekBar seekBar;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        verifyView=(VerifyView)findViewById(R.id.verifyView1);
        verifyView.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.icon));

        seekBar=(SeekBar)findViewById(R.id.seekBar1);
        seekBar.setMax(10000);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO 自动生成的方法存根
                verifyView.setMove(progress*0.0001);
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
        seekBar.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO 自动生成的方法存根
                switch(event.getAction()){
                    case MotionEvent.ACTION_UP:
                        boolean isTrue=verifyView.isTrue(0.02);//允许有2%误差
                        if(isTrue){
                            showToast("验证成功");
                        }
                        break;
                }
                return false;
            }

        });

        button1=(Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO 自动生成的方法存根
                reInit();
            }

        });


    }

    Toast toast;
    void showToast(String msg){
        if(toast!=null)toast.cancel();

        toast=Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.show();
    }

    void reInit(){
        verifyView.setReDraw();
        seekBar.setProgress(0);
    }
}
