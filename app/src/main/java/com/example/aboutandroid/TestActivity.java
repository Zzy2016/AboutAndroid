package com.example.aboutandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {


    TextView tv1,tv2,tv3,tv4;
    Uri uri=Uri.parse("content://com.example.aboutandroid/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        tv1=(TextView)findViewById(R.id.tv1);
        tv2=(TextView)findViewById(R.id.tv2);
        tv3=(TextView)findViewById(R.id.tv3);
        tv4=(TextView)findViewById(R.id.tv4);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor=getContentResolver().query(uri,null,"query",null,null);
                System.out.println("查询"+cursor);
            }
        });

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues contentValues=new ContentValues();
                contentValues.put("ceshi","hahha");
                Uri newUri=getContentResolver().insert(uri,contentValues);
                System.out.println("插入"+newUri.toString());
            }
        });

        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues contentValues=new ContentValues();
                contentValues.put("update","update");
                int count=getContentResolver().update(uri,contentValues,"update",null);
                System.out.println("更新"+count);
            }
        });

        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count=getContentResolver().delete(uri,"delete",null);
                System.out.println("删除"+count);
            }
        });
    }
}
