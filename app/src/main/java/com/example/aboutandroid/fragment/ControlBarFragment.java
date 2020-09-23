package com.example.aboutandroid.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aboutandroid.R;
import com.example.aboutandroid.bean.Sound;

import androidx.fragment.app.Fragment;


public class ControlBarFragment extends Fragment {


    private ImageView img1, imgList, imgPlay, imgNext;
    private TextView tvName,tvSonger;
    private boolean isPlaying;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        tvSonger=view.findViewById(R.id.tvSonger);


        imgPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPlaying){
                    imgPlay.setBackgroundResource(R.drawable.playbar_btn_play);
                }else {
                    imgPlay.setBackgroundResource(R.drawable.playbar_btn_pause);
                }
                isPlaying=!isPlaying;
            }
        });

    }

    public void changeInfo(Sound sound){
        tvName.setText(sound.getTitle());
    }

}
