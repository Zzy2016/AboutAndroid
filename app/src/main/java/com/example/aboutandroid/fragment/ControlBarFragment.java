package com.example.aboutandroid.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aboutandroid.R;
import com.example.aboutandroid.bean.Sound;
import com.example.aboutandroid.inter.RefreshSound;
import com.example.aboutandroid.util.SharedPreferencesUtil;
import com.google.gson.Gson;

import androidx.fragment.app.Fragment;

/*
* 注册广播接收器，接受各类广播，修改控制栏状态
* */
public class ControlBarFragment extends Fragment implements RefreshSound {


    private ImageView img1, imgList, imgPlay, imgNext;
    private TextView tvName, tvSonger;
    private boolean isPlaying;

    private MyReceiver myReceiver;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myReceiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("music_playing");
        getActivity().registerReceiver(myReceiver, intentFilter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_control_bar, container, false);
        initView(view);
        return view;
    }


    public void initView(View view) {
        img1 = view.findViewById(R.id.img1);
        imgList = view.findViewById(R.id.imgList);
        imgPlay = view.findViewById(R.id.imgPlay);
        imgNext = view.findViewById(R.id.imgNext);
        tvName = view.findViewById(R.id.tvName);
        tvSonger = view.findViewById(R.id.tvSonger);


        imgPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();


                if (isPlaying) {
//                    停止
                    imgPlay.setBackgroundResource(R.drawable.playbar_btn_play);

//                    imgPlay.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.playbar_btn_play));
                    intent.setAction("sound_stop");
                } else {
//                    开始
//                    imgPlay.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.playbar_btn_pause));
                    imgPlay.setBackgroundResource(R.drawable.playbar_btn_pause);
                    intent.setAction("sound_restart");
                }
                getActivity().sendBroadcast(intent);
                isPlaying = !isPlaying;
            }
        });


    }

    @Override
    public void refreshSound() {
        String json = (String) SharedPreferencesUtil.getData("currentSong", "");
        if (json != "") {
            Gson gson = new Gson();
            Sound sound = gson.fromJson(json, Sound.class);
            tvName.setText(sound.getTitle());
        }
    }


    public class MyReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("music_playing")) {
                Log.e("----", intent.getSerializableExtra("song").toString());
//                Sound sound1= (Sound) SharedPreferencesUtil.getData("currentSong",null);
                Sound sound = (Sound) intent.getSerializableExtra("song");

                String json = (String) SharedPreferencesUtil.getData("currentSong", "");
                Gson gson = new Gson();
                Sound sound1 = gson.fromJson(json, Sound.class);

//                Log.e("curr",sound1.getTitle());

                String[] title = sound.getTitle().split("-");

                tvName.setText(title[0]);
                tvSonger.setText(title[1]);
            }


            Sound sound = (Sound) intent.getSerializableExtra("song");
            String json = (String) SharedPreferencesUtil.getData("currentSong", "");
            Gson gson = new Gson();
            String[] title = sound.getTitle().split("-");


            String type = intent.getAction();
            switch (type) {
                case "music_playing":
                    tvName.setText(title[0]);
                    tvSonger.setText(title[1]);
                    imgPlay.setBackgroundResource(R.drawable.playbar_btn_pause);
                    break;
                case "sound_stop":
                    imgPlay.setBackgroundResource(R.drawable.playbar_btn_play);
                    break;
                case "sound_restart":
                    imgPlay.setBackgroundResource(R.drawable.playbar_btn_pause);
                    break;
            }
        }
    }


}
