package com.askcicle.library.rx.retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by _SOLID
 * Date:2016/7/27
 * Time:15:57
 */
public class HttpResult<T> {

    @SerializedName(value = "c")
    public long code;
    @SerializedName(value = "m")
    public T data;
}
