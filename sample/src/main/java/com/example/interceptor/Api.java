package com.example.interceptor;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * ©2016-2017 kmhealthcloud.All Rights Reserved <p/>
 * Created by: L  <br/>
 * Description:
 */
public interface Api {

    @GET("BaikeLemmaCardApi")
    Observable<Response> baike(
            @Query("appid") String appid,
            @Query("bk_key") String bk_key,
            @Query("scope") String scope,
            @Query("format") String format,
            @Query("bk_length") String bk_length
    );
}
