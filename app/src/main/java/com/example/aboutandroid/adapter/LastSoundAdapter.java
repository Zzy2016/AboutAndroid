package com.example.aboutandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.aboutandroid.R;
import com.example.aboutandroid.bean.LastSound;
import com.example.aboutandroid.fragment.ItemFragment1;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author: Administrator
 * @date: 2020-07-31
 */
public class LastSoundAdapter extends RecyclerView.Adapter<LastSoundAdapter.ViewHolder> {


    private List<LastSound> lastSoundList;
    private Context context;

    public LastSoundAdapter(List<LastSound> newSoundList, Context context) {
        this.lastSoundList = newSoundList;
        this.context = context;
    }

   /* ViewGroup.LayoutParams lp = ll.getLayoutParams();
if (heightList.size() <= helper.getAdapterPosition()) {
        heightList.add((int) (200 + Math.random() * 300));
    }
    lp.height = heightList.get(helper.getAdapterPosition());
ll.setLayoutParams(lp);*/

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_new_sound, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViewGroup.LayoutParams lp = holder.clItem.getLayoutParams();
        lp.height = (int) (200 + Math.random() * 300);
        holder.clItem.setLayoutParams(lp);
    }

    @Override
    public int getItemCount() {
        return lastSoundList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ConstraintLayout clItem;
        private ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            clItem = itemView.findViewById(R.id.item);
            img = itemView.findViewById(R.id.imageViewIcon);

        }
    }

}
