package com.example.interceptor;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

/**
 * ©2016-2017 kmhealthcloud.All Rights Reserved <p/>
 * Created by: L  <br/>
 * Description:
 */
public interface Api {

    @Headers("apikey:"+Constant.API_KEY)
    @GET(Urls.RECIPE)
    Observable<Response> recipe(@Query("name")String name);
}
