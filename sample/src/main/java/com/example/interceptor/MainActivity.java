package com.example.interceptor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.interceptor.utils.LogUtils;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import okhttp3.logging.HttpLoggingInterceptor.Logger;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private Api mApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new Logger() {
            @Override
            public void log(String message) {
                LogUtils.d(message);
            }
        });
        loggingInterceptor.setLevel(Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10000, TimeUnit.MILLISECONDS)
               /* .addInterceptor(new HttpLogInterceptor(new ILogger() {
                    @Override
                    public void d(String tag, String msg) {
                        LogUtils.d(msg);
                    }
                }))*/
//                .addInterceptor(new HttpLogInterceptor())

                .addInterceptor(loggingInterceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
        mApi = retrofit.create(Api.class);
    }

    public void recipe(View v) {
        /*Log.i("library debug:", com.halcyon.logger.BuildConfig.DEBUG+"");
        Log.i("sample debug:",""+ BuildConfig.DEBUG);*/
        mApi
                .recipe("宫保鸡丁")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Response>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("sample", "onError");
                    }

                    @Override
                    public void onNext(Response response) {
                        Log.i("sample", "onNext:" + response.toString());
                    }
                });
    }
}
