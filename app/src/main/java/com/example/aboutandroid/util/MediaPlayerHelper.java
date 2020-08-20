package com.example.aboutandroid.util;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

import com.google.gson.internal.$Gson$Preconditions;

public class MediaPlayerHelper {

    private static MediaPlayerHelper instance;

    private MediaPlayer mediaPlayer;
    private Context context;

    public void setOnMediaPlayerHelperListener(OnMediaPlayerHelperListener onMediaPlayerHelperListener) {
        this.onMediaPlayerHelperListener = onMediaPlayerHelperListener;
    }

    private OnMediaPlayerHelperListener onMediaPlayerHelperListener;

    public static MediaPlayerHelper getInstance(Context context){
        if(instance==null){
            synchronized (MediaPlayerHelper.class){
                if(instance==null){
                    instance=new MediaPlayerHelper(context);
                }
            }
        }
        return instance;
    }

    public MediaPlayerHelper(Context context) {
        context=context;
        mediaPlayer=new MediaPlayer();

    }

//   当前需要播放的音乐的

    public void setPath(String path){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.reset();
        }

        try{
            mediaPlayer.setDataSource( path);
        }catch (Exception e){
            e.printStackTrace();
        }

        mediaPlayer.prepareAsync();

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
//                if(onMediaPlayerHelperListener!=null){
//                    onPrepared(mediaPlayer);
//                }
                mediaPlayer.start();
            }
        });

    }


    public void start(){
        if(mediaPlayer.isPlaying())return;
        mediaPlayer.start();
    }

    public void pause(){
        mediaPlayer.pause();
    }

    public interface OnMediaPlayerHelperListener{
        void onPrepared(MediaPlayer mediaPlayer);
    }
}
