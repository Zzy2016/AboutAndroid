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

            Log.e("------0", cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION)) + " ");
            Log.e("------", cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION)) + "                 " + cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE)));
//            Log.e("声音----------","text"+cursor.getString(0));
//            Log.e("声音----------","text"+cursor.getString(1));
//            Log.e("声音----------","text"+cursor.getString(2));
//            Log.e("声音----------","text"+cursor.getString(3));
//            Log.e("声音----------","text"+cursor.getString(4));
//            Log.e("声音----------","text"+cursor.getString(5));
//            Log.e("声音----------","text"+cursor.getString(6));
//            Log.e("声音----------","text"+cursor.getString(7));
//            Log.e("声音----------","text"+cursor.getString(8));
//            Log.e("声音----------","text"+cursor.getString(9));
//            Log.e("声音----------","text"+cursor.getString(10));
//            Log.e("声音----------","text"+cursor.getString(11));
//            Log.e("声音----------","text"+cursor.getString(12));
//            Log.e("声音----------","text"+cursor.getString(13));
//            Log.e("声音----------","text"+cursor.getString(14));
//            Log.e("声音----------","text"+cursor.getString(15));
//            Log.e("声音----------","text"+cursor.getString(16));
//            Log.e("声音----------","text"+cursor.getString(17));
//            Log.e("声音----------","text"+cursor.getString(18));
//            Log.e("声音----------","text"+cursor.getString(19));
//            Log.e("声音----------","text"+cursor.getString(20));
//            Log.e("声音----------","text"+cursor.getString(21));
//            Log.e("声音----------","text"+cursor.getString(22));
//            Log.e("声音----------","text"+cursor.getString(23));
//            Log.e("声音----------","text"+cursor.getString(24));
//            Log.e("声音----------","text"+cursor.getString(25));
//            Log.e("声音----------","text"+cursor.getString(26));
//            Log.e("声音----------","text"+cursor.getString(27));
//            Log.e("声音----------","text"+cursor.getString(28));
//            Log.e("声音----------","text"+cursor.getString(29));
//            Log.e("声音----------","text"+cursor.getString(30));
//            Log.e("声音----------","text"+cursor.getString(31));
//            Log.e("声音----------","text"+cursor.getString(32));
//            Log.e("声音----------","text"+cursor.getString(33));
//            Log.e("声音----------","text"+cursor.getString(34));
//            Log.e("声音----------","text"+cursor.getString(35));
//            Log.e("声音----------","text"+cursor.getString(36));
//            Log.e("声音----------","text"+cursor.getString(37));
//            Log.e("声音----------","text"+cursor.getString(38));
//            Log.e("声音----------","text"+cursor.getString(39));
//            Log.e("声音----------","text"+cursor.getString(40));
//            Log.e("声音----------","text"+cursor.getString(41));
//            Log.e("声音----------","text"+cursor.getString(42));
//            Log.e("声音----------","text"+cursor.getString(43));
//            Log.e("声音----------","text"+cursor.getString(44));
//            Log.e("声音----------","text"+cursor.getString(45));
//            Log.e("声音----------","text"+cursor.getString(46));
//            Log.e("声音----------","text"+cursor.getString(47));
//            Log.e("声音----------","text"+cursor.getString(48));
//            Log.e("声音----------","text"+cursor.getString(49));
//            Log.e("声音----------","text"+cursor.getString(50));
//            Log.e("声音----------","text"+cursor.getString(51));
//            Log.e("声音----------","text"+cursor.getString(52));
//            Log.e("声音----------","text"+cursor.getString(53));
//            Log.e("声音----------","text"+cursor.getString(54));
//            Log.e("声音----------","text"+cursor.getString(55));
//            Log.e("声音----------","text"+cursor.getString(56));
//            Log.e("声音----------","text"+cursor.getString(57));
//            Log.e("声音----------","text"+cursor.getString(58));
//            Log.e("声音----------","text"+cursor.getString(59));
//            Log.e("声音----------","text"+cursor.getString(60));
//            Log.e("声音----------","text"+cursor.getString(61));
//            Log.e("声音----------","text"+cursor.getString(62));
//            Log.e("声音----------","text"+cursor.getString(63));
//            Log.e("声音----------","text"+cursor.getString(64));


        }
    }

}
