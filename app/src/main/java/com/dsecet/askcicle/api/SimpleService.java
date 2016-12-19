package com.dsecet.askcicle.api;

import com.askcicle.library.rx.retrofit.BaseResultVo;
import com.askcicle.library.rx.retrofit.HttpResult;
import com.dsecet.askcicle.mode.University;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;
import rx.Observable;


/**
 * Created by lin
 * Date:2016/8/3
 * Time:9:28
 */
public interface SimpleService {

    String BASE_URL = "http://115.29.136.168/api/";

    /**
     * 获取发布干货的日期
     *
     * @return
     */
    @GET("day/history")
    Observable<HttpResult<String>> getRecentlyDate();

    /**
     * 获取发布干货的日期
     *
     * @return
     */
    @Headers("Content-Type: application/json")
    @GET("organiztion/list")
    Observable<HttpResult<BaseResultVo<University>>> getUniversitys(@QueryMap Map<String, Object> options);




}
