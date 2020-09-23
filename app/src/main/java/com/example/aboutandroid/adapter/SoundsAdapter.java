package com.example.aboutandroid.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aboutandroid.R;
import com.example.aboutandroid.bean.Sound;
import com.example.aboutandroid.util.MediaPlayerHelper;

import java.io.IOException;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author: Administrator
 * @date: 2020-07-17
 */
public class SoundsAdapter extends RecyclerView.Adapter<SoundsAdapter.ViewHolder> {

    private List<Sound> soundList;
    private Context context;
    private MediaPlayerHelper mediaPlayerHelper;


    public SoundsAdapter(List<Sound> soundList, Context context) {
        this.soundList = soundList;
        this.context = context;
        mediaPlayerHelper=new MediaPlayerHelper(context);
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
        holder.tvDesc.setText(soundList.get(position).getAlbum());

        holder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                MediaPlayer mediaPlayer=new MediaPlayer();
//                try {
//                    mediaPlayer.setDataSource(soundList.get(position).getUrl());
//                    mediaPlayer.prepare();
//                    mediaPlayer.start();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
                mediaPlayerHelper.setPath(soundList.get(position).getUrl());
                mediaPlayerHelper.start();

            }
        });

        Log.e("wenjian-->",soundList.get(position).getUrl());


//        Uri uri=Uri.parse("");
//        MediaPlayer mediaPlayer=new MediaPlayer();
//        mediaPlayer.setDataSource(this,uri);
//        mediaPlayer.prepare();
//        mediaPlayer.start();

    }

    @Override
    public int getItemCount() {
        return soundList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView tvName;
        private TextView tvDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgHead);
            tvName = itemView.findViewById(R.id.tvName);
            tvDesc = itemView.findViewById(R.id.tvDeac);
        }
    }

}
