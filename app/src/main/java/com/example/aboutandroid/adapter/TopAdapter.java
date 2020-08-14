package com.example.aboutandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.aboutandroid.R;
import com.example.aboutandroid.TopModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author: Administrator
 * @date: 2020-08-14
 */
public class TopAdapter extends RecyclerView.Adapter<TopAdapter.ViewHolder> {


    private List<TopModel.SongListBean> listBeans;
    private Context context;

    public TopAdapter(List<TopModel.SongListBean> listBeans, Context context) {
        this.listBeans = listBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sound_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ViewGroup.LayoutParams params = holder.imgItemIcon.getLayoutParams();
        int type = position % 5;
        int height = 30;
        switch (type) {
            case 0:
                height = 500;
                break;
            case 1:
                height = 750;
                break;
            case 2:
                height = 880;
                break;
            case 3:
                height = 360;
                break;
            case 4:
                height = 660;
                break;
            default:
                break;
        }

        params.height = height;
        holder.imgItemIcon.setLayoutParams(params);

        holder.tvItemName.setText(listBeans.get(position).getTitle());
        Glide.with(context).load(listBeans.get(position).getPic_big()).into(holder.imgItemIcon);
    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvItemName;
        private ImageView imgItemIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItemName = itemView.findViewById(R.id.tvItemName);
            imgItemIcon = itemView.findViewById(R.id.imgItemIcon);
        }
    }
}
