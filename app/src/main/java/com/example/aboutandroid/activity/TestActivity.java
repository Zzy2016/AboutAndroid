package com.example.aboutandroid.activity;

import android.os.Bundle;
import android.util.Log;

import com.alibaba.fastjson.JSONObject;
import com.example.aboutandroid.R;
import com.example.aboutandroid.TopModel;
import com.example.aboutandroid.util.util;


import androidx.appcompat.app.AppCompatActivity;


public class TestActivity extends AppCompatActivity {


    private String TAG = "TestActivity--》";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


//        RetrofitFactory.create(ApiService.class).getTopList().bindToLifecycle(lifecycleProvider, Lifecycle.Event.ON_DESTROY).enqueue(new Callback() {
//            @Override
//            public void onStart(Call call) {
//
//            }
//
//            @NonNull
//            @Override
//            public HttpError parseThrowable(Call call, Throwable t) {
//                return null;
//            }
//
//            @NonNull
//            @Override
//            public Object transform(Call call, Object o) {
//                return null;
//            }
//
//            @Override
//            public void onError(Call call, HttpError error) {
//                Log.e(TAG, "onError" + error);
//            }
//
//            @Override
//            public void onSuccess(Call call, Object o) {
//                Log.e(TAG, "onSuccess" + o.toString());
//            }
//
//            @Override
//            public void onCompleted(Call call, @Nullable Throwable t) {
//                Log.e(TAG, "onCompleted" + t.toString());
//            }
//        });


//        Retrofit retrofit1 = new Retrofit.Builder().baseUrl(Constant.baseUrl).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).build();
//        retrofit1.create(ApiService.class).getTopList().enqueue(new Callback() {
//            @Override
//            public void onResponse(Call call, Response response) {
//                try {
//                    if (response.isSuccessful()) {
//                        Log.e(TAG,"success"+response.body().toString());
//                    } else {
//                        Log.e(TAG,"error"+response.body().toString());
//                    }
//                } catch (Exception e) {
//                    Log.e(TAG,"error1"+e.toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Call call, Throwable t) {
//                Log.e(TAG,"onFailure"+t.toString());
//            }
//        });


//        try {
//            InputStreamReader inputStreamReader=new InputStreamReader(getResources().openRawResource(R.raw.text));
//            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
//            String line="";
//            String result="";
//            while ((line=bufferedReader.readLine())!=null){
//                result+=line;
//                Log.e("----",line);
//            }
//
//        }catch (Exception e){
//
//        }


//        try {
//            InputStreamReader inputReader = new InputStreamReader(getResources().getAssets().open("text.txt"));
//            BufferedReader bufReader = new BufferedReader(inputReader);
//            String line = "";
//            String Result = "";
//            while ((line = bufReader.readLine()) != null)
//            {
//                Result += line;
//                Log.e("====", line);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        TopModel topModel = JSONObject.parseObject(util.getOriginalFundData(this), TopModel.class);
        Log.e("=======", topModel.toString());


        for (int i = 0; i < topModel.getSong_list().size(); i++) {
            Log.e("-->", topModel.getSong_list().get(i).getAlbum_title());
        }

    }
}
