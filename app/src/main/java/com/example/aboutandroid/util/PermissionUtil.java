package com.example.aboutandroid.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;

import java.util.ArrayList;
import java.util.List;

import androidx.core.app.ActivityCompat;

/**
 * @author: Administrator
 * @date: 2020-07-17
 */
public class PermissionUtil {

    private static List<String> permissionList = new ArrayList<>();

    /*检查权限*/
    public static void checkSinglePermission() {

    }

    public static void checkPermissions(Context context, String[] permissions) {
        for (int i = 0; i < permissions.length; i++) {
            if (ActivityCompat.checkSelfPermission(context, permissions[i]) == PackageManager.PERMISSION_GRANTED) {

            } else {
                permissionList.add(permissions[i]);
            }
        }
        if (permissionList.size() == 0) {

        } else {
            requestPermissions(context);
        }

    }

    public static void requestPermissions(Context context) {
        String [] pers=new String[permissionList.size()];
        for(int i=0;i<permissionList.size();i++){
            pers[i]=permissionList.get(i);
        }
        ActivityCompat.requestPermissions((Activity) context, pers, 0);
    }
}
