package com.example.interceptor;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * ©2016-2017 kmhealthcloud.All Rights Reserved <p/>
 * Created by: L  <br/>
 * Description:
 */
public interface Api {

    @GET(Urls.USER)
    Observable<UserInfoResponse> userInfo(@Path("user") String user);
}
