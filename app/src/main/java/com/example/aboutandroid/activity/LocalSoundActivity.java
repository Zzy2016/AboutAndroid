package com.example.aboutandroid.activity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;

import com.example.aboutandroid.R;
import com.example.aboutandroid.adapter.SoundsAdapter;
import com.example.aboutandroid.base.BaseActivity;
import com.example.aboutandroid.bean.Sound;
import com.example.aboutandroid.databinding.ActivityLocalSoundBinding;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;

public class LocalSoundActivity extends BaseActivity {

    ActivityLocalSoundBinding binding;
    private SoundsAdapter soundsAdapter;
    private List<Sound> soundList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_local_sound);
        binding = ActivityLocalSoundBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        soundList = new ArrayList<>();
        getAllList();
        soundsAdapter = new SoundsAdapter(soundList, this);
        binding.recyclerView.setAdapter(soundsAdapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    public void getAllList() {
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
//        Cursor cursor=contentResolver.query(MediaStore.Audio.Media.TITLE,null,null,null,null);
//        Cursor cursor = contentResolver.query(Uri.parse(MediaStore.Audio.Media.DURATION), null, null, null, null);

        while (cursor.moveToNext()) {
            Sound sound = new Sound();
            sound.setAlbum(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM)));
            sound.setArtist(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST)));
            sound.setDisplayName(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME)));
            sound.setDuration(cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION)));
            sound.setUrl(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA)));
            sound.setTitle(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)));

            soundList.add(sound);

        }
    }

}
