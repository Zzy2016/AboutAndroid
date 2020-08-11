package com.example.aboutandroid.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.aboutandroid.R;
import com.example.aboutandroid.activity.LocalSoundActivity;
import com.example.aboutandroid.databinding.FragmentListBinding;

import androidx.fragment.app.Fragment;


public class ListFragment extends Fragment {


    private FragmentListBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_list, container, false);
        binding=FragmentListBinding.inflate(inflater,container,false);
        initView();
        return binding.getRoot();
    }

    public void initView(){
//        binding.tvTitle.setText("ceshibiaoti");
        binding.tvLocalMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), LocalSoundActivity.class);
                startActivity(intent);

            }
        });
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            Log.e("-------------", "ListFragment");
        }
    }
}
