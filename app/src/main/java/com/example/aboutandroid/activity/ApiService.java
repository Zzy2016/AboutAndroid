package com.example.aboutandroid.activity;

import com.example.aboutandroid.TopModel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author: Administrator
 * @date: 2020-08-11
 */
public interface ApiService {

//    http://tingapi.ting.baidu.com/v1/restserver/ting?from=qianqian&version=2.1.0&method=baidu.ting.billboard.billList&format=json&type=1&offset=0&size=50

    @GET("restserver/ting?from=qianqian&version=2.1.0&method=baidu.ting.billboard.billList&format=json&type=1&offset=0&size=10")
    Call<TopModel> getTopList();



}
