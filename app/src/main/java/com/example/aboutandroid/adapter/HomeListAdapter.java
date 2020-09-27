package com.example.aboutandroid.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aboutandroid.R;
import com.example.aboutandroid.activity.SoundsActivity;
import com.example.aboutandroid.services.MyControlService;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author: Administrator
 * @date: 2020-07-16
 */
public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.ViewHolder> {


    private String[] strings;

    private Context context;

    public HomeListAdapter(Context context) {
        this.context = context;

        strings = context.getResources().getStringArray(R.array.splash_str);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.homt_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.e("------------------>", strings[position]);
        holder.tvItem.setText(strings[position]);


        holder.tvItem.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                if (position == 0) {
//                    Intent intent = new Intent(context, TestActivity.class);
//                    context.startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(context, SoundsActivity.class);
                    context.startActivity(intent);
//                    Intent intent = new Intent(context, MyControlService.class);
////                    context.startForegroundService(intent);
//
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                        //android8.0以上通过startForegroundService启动service
//                        context.startForegroundService(intent);
//                    } else {
//                        context.startService(intent);
//                    }
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return strings.length;
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvItem = itemView.findViewById(R.id.item);
        }
    }
}
