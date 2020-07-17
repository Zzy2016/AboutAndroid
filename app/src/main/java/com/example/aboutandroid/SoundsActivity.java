package com.example.aboutandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;

import com.example.aboutandroid.adapter.SoundsAdapter;
import com.example.aboutandroid.base.BaseActivity;
import com.example.aboutandroid.bean.Sound;

import java.util.ArrayList;
import java.util.List;

public class SoundsActivity extends BaseActivity {

    private RecyclerView rvSoundList;

    private List<Sound> soundList;
    private SoundsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sounds);

        soundList = new ArrayList<>();

        Cursor cursor = getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
        while (cursor.moveToNext()) {
            Log.e("sounds---->", cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME)));
            Sound sound = new Sound();
            sound.setName(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME)));
            soundList.add(sound);
        }

        adapter = new SoundsAdapter(soundList, this);
        rvSoundList = (RecyclerView) findViewById(R.id.rvSoundList);
        rvSoundList.setAdapter(adapter);
        rvSoundList.setLayoutManager(new LinearLayoutManager(this));
    }


}
