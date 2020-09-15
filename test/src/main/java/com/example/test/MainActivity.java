package com.example.test;

import androidx.activity.ComponentActivity;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Permission;
import java.text.Format;

import static androidx.core.content.PermissionChecker.PERMISSION_GRANTED;

public class MainActivity extends AppCompatActivity {


    TextView tv, tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8;
    MyServiceBind.MyBinder myBinder;
    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder = (MyServiceBind.MyBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            myBinder = null;
        }
    };

    //    ByteArrayOutputStream image0 = new ByteArrayOutputStream();
//    ByteArrayOutputStream image1 = new ByteArrayOutputStream();
//    ByteArrayOutputStream image2 = new ByteArrayOutputStream();
//    ByteArrayOutputStream image2 = new ByteArrayOutputStream();
    ByteArrayOutputStream[] images = new ByteArrayOutputStream[3];

    String[] patients = new String[]{"100123", "100124", "100125"};

    String token = "37_Ij3X3JvgK1wsifC9fZ4JXJpzgP_rbANmOBANUOHAWnG4i4UEXDSRWua5p4dGe2FCcnmgye2miV16QroQQHv9FItwqoXNll54YGqinxfer-X-zS-z4DFubm-lBdlQk6TojkzeRgWwDTxGra_fJIFcACAONK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 3; i++) {
            images[i] = new ByteArrayOutputStream();
        }

        check();
        tv = (TextView) findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                startService(intent);
            }
        });

        tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                stopService(intent);
            }
        });

        tv2 = (TextView) findViewById(R.id.tv2);
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyServiceBind.class);
                bindService(intent, serviceConnection, BIND_AUTO_CREATE);
            }
        });
        tv3 = (TextView) findViewById(R.id.tv3);
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyServiceBind.class);
                unbindService(serviceConnection);
            }
        });

        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);
        tv6 = (TextView) findViewById(R.id.tv6);

        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myBinder.test();
            }
        });

        tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myBinder.test1();
            }
        });

        tv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myBinder.test2();
            }
        });

        tv7 = (TextView) findViewById(R.id.tv7);
        tv7.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MService.class);
//                startService(intent);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    //android8.0以上通过startForegroundService启动service
                    startForegroundService(intent);
                } else {
                    startService(intent);
                }
            }
        });

        tv8 = (TextView) findViewById(R.id.tv8);
        tv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, MyIntentService.class);
//
//                for (int i = 0; i < 10; i++) {
//                    startService(intent);
//                }

                try {
                    for (int i = 0; i < 3; i++) {
                        File file = new File(getExternalFilesDir("") + patients[i] + ".jpg");
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        Bitmap bitmap = BitmapFactory.decodeByteArray(images[i].toByteArray(), 0, images[i].toByteArray().length);
                        Log.e("Bitmap---", (bitmap == null) + "  " + i);
                    }
                } catch (Exception e) {
                    Log.e("111", e.toString());
                }
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                getToken();
//                saveImg(token, "123");
            }
        }).start();

    }

    public void getToken() {
        String appid = "wx06928842b7177b6e";
        String secret = "2cd7cfbd6a1ab81fb86fa0e4a280f3c2";
//        https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxdd068eab2feb60af&secret=f4e97614b0f37fe3b87e1d91ff246660
        String path = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid + "&secret=" + secret;
        try {
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            byte[] buffer = new byte[1024];
            if (connection.getResponseCode() == 200) {
                Log.e("success", "1");
                int len = -1;
                StringBuffer stringBuffer = new StringBuffer();
                while ((len = inputStream.read(buffer)) != -1) {
                    stringBuffer.append(new String(buffer, 0, len));
                }
                Log.e("result", stringBuffer.toString());
                JSONObject jsonObject = new JSONObject(stringBuffer.toString());
                Log.e("result1", jsonObject.getString("access_token"));
                doMakeCode(jsonObject.getString("access_token"));
            } else {
                Log.e("fail", "2");
            }
        } catch (Exception e) {
            Log.e("exception", e.toString());
        }
    }


    public void doMakeCode(String token) {
        for (int i = 0; i < patients.length; i++) {
            saveImg(token, patients[i], images[i]);
        }
//        saveImg(token, patients[0]);
    }

    public void saveImg(String token, String patient, ByteArrayOutputStream byteArrayOutputStream) {
        try {
            URL url = new URL("https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=" + token);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("scene", patient);
            jsonObject.put("page", "pages/Login/Login");
            connection.setRequestMethod("POST");

            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.connect();

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(jsonObject.toString().getBytes());
            outputStream.flush();
            outputStream.close();


            if (connection.getResponseCode() == 200) {
                byteArrayOutputStream = new ByteArrayOutputStream();
                InputStream inputStream = connection.getInputStream();


                int len = -1;
                byte[] buffer = new byte[1024];

//                StringBuffer stringBuffer = new StringBuffer();
//                while ((len = inputStream.read(buffer)) != -1) {
//                    stringBuffer.append(new String(buffer, 0, len));
//                }
//
//                Log.e("result", stringBuffer.toString());



                while ((len = inputStream.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, len);
                }
                byte[] img = byteArrayOutputStream.toByteArray();
                File file = new File(getExternalFilesDir("") + patient + ".jpg");
                if (!file.exists()) {
                    file.createNewFile();
                }
                Log.e("------", byteArrayOutputStream.toByteArray().length + "");
                FileOutputStream fileOutputStream = new FileOutputStream(file);
//                BitmapFactory .Options opts = new BitmapFactory.Options();
//                opts. inJustDecodeBounds = false ;//inJustDecodeBounds 需要设置为false，如果设置为true，那么将返回null
//                opts. inSampleSize = 100 ;
                Bitmap bitmap = BitmapFactory.decodeByteArray(img, 0, img.length);

                if (bitmap == null) {
                    Log.e("bitmap==null", "1");
                } else {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 50, fileOutputStream);
                }


                Log.e("获取图片", "1");
            } else {
                Log.e("获取图片", "2");
            }
        } catch (Exception e) {
            Log.e("exception", e.toString());
        }

    }


    public void check() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PERMISSION_GRANTED) {

        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.e("123", requestCode + "");
    }
}
