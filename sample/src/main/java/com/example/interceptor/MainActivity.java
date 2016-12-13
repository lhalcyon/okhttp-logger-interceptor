package com.example.interceptor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.interceptor.utils.LogUtils;
import com.google.gson.Gson;
import com.halcyon.logger.HttpLogInterceptor;
import com.halcyon.logger.ILogger;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private Api mApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10000, TimeUnit.MILLISECONDS)
//                .addInterceptor(new HttpLogInterceptor())
                .addInterceptor(new HttpLogInterceptor(new ILogger() {
                    @Override
                    public void log(String msg) {
                        LogUtils.e(msg);
                    }
                }))
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
        mApi = retrofit.create(Api.class);
    }

    public void request(View v) {
        mApi
                .userInfo("lhalcyon")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserInfoResponse>() {
                    @Override
                    public void onCompleted() {
                        LogUtils.w("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.w("onError");
                    }

                    @Override
                    public void onNext(UserInfoResponse userInfoResponse) {
                        LogUtils.w("onNext "+userInfoResponse.toString());
                    }
                });
    }
}
