package com.example.aboutandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aboutandroid.R;
import com.example.aboutandroid.bean.Sound;

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


    public SoundsAdapter(List<Sound> soundList, Context context) {
        this.soundList = soundList;
        this.context = context;
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
