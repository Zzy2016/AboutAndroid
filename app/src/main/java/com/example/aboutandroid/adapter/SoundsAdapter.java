package com.example.aboutandroid.adapter;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.aboutandroid.R;
import com.example.aboutandroid.bean.Sound;
import com.example.aboutandroid.services.MyControlService;
import com.example.aboutandroid.util.MediaPlayerHelper;
import com.example.aboutandroid.util.SharedPreferencesUtil;



import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author: Administrator
 * @date: 2020-07-17
 */
public class SoundsAdapter extends RecyclerView.Adapter<SoundsAdapter.ViewHolder> {

    private List<Sound> soundList;
    private Context context;
//    private MediaPlayerHelper mediaPlayerHelper;


    public SoundsAdapter(List<Sound> soundList, Context context) {
        this.soundList = soundList;
        this.context = context;
//        mediaPlayerHelper = new MediaPlayerHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sounds, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(soundList.get(position).getTitle());
        holder.tvDesc.setText(soundList.get(position).getAlbum() + " --- " + soundList.get(position).getArtist());

        SharedPreferencesUtil.putData("currentTitle", soundList.get(position).getTitle());
        SharedPreferencesUtil.putData("currentAlbum", soundList.get(position).getAlbum());


//        Log.e("current",soundList.get(position).toString());
        JSONObject jsonObject = (JSONObject) JSON.toJSON(soundList.get(position));
        Log.e("json",jsonObject.toString());
        SharedPreferencesUtil.putData("currentSong", jsonObject.toString());

        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //开始播放并且发送广播，更改控制栏和notification内容
                /*打开notification，需要判断是否开启了*/
//                mediaPlayerHelper.setPath(soundList.get(position).getUrl());
//                mediaPlayerHelper.start();


                Intent intent1 = new Intent("music_playing");
                Bundle bundle = new Bundle();
                bundle.putSerializable("song", soundList.get(position));
                intent1.putExtras(bundle);
                context.sendBroadcast(intent1);


                if (!judgeServiceRunning("com.example.aboutandroid.services.MyControlService")) {
                    Intent intent = new Intent(context, MyControlService.class);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        //android8.0以上通过startForegroundService启动service
                        context.startForegroundService(intent);
                    } else {
                        context.startService(intent);
                    }
                }

            }
        });

        Log.e("wenjian-->", soundList.get(position).getUrl());
    }


    //    判断ForService是否运行
    public boolean judgeServiceRunning(String service) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo serviceInfo : activityManager.getRunningServices(Integer.MAX_VALUE)) {
            if (service.equals(serviceInfo.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getItemCount() {
        return soundList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {


        private ConstraintLayout item;
        private ImageView img;
        private TextView tvName;
        private TextView tvDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.item);
            img = itemView.findViewById(R.id.imgHead);
            tvName = itemView.findViewById(R.id.tvName);
            tvDesc = itemView.findViewById(R.id.tvDeac);
        }
    }

}
