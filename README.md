# okhttp-logger-interceptor

在开发中,当访问网络时,如有请求、返回日志，则能及时地了解请求状况，返回结果，提升开发的效率，省去抓包的烦恼.以下描述的问题为[Okhttp](https://github.com/square/okhttp)中遇到的

Square有提供一个 [okhttp-logging-interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor) . 

效果如图

![okhttp-logging-interceptor](https://github.com/lhalcyon/okhttp-logger-interceptor/raw/master/screenshots/okhttp-logging-interceptor.png)

一般开发人员最关心的是返回的body部分,传输数据格式通常为json,在Logcat下没有格式化展示,如果数据过长,甚至不能完全展示,这给我们想直接[GsonFormat](https://plugins.jetbrains.com/plugin/7654?pr=idea)生成bean造成了不便.

---

所以,在[okhttp-logging-interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor) 的基础上做了删改,然后弄了一个简易的 [okhttp-logger-interceptor](https://github.com/lhalcyon/okhttp-logger-interceptor) ,如图

![okhttp-logger-interceptor](https://github.com/lhalcyon/okhttp-logger-interceptor/raw/master/screenshots/okhttp-logger-interceptor.png)

输出日志将json格式化输出,更加清晰.



## Download

下载并导入库  

或者 Maven

```
<dependency>
  <groupId>com.lhalcyon</groupId>
  <artifactId>okhttp-logger-interceptor</artifactId>
  <version>1.0.0</version>
  <type>pom</type>
</dependency> 
```

或者 通过Gradle

```
compile 'com.lhalcyon:okhttp-logger-interceptor:1.0.0'
```



## Usage

```
 OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HttpLogInterceptor()) 
                .build();
```

无参构造默认使用的是`android.util.Log` .对于有日志开关需求的,可以传入一个`com.halcyon.logger.ILogger`的实现类.库中有一个实现类

```
OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HttpLogInterceptor(Logger.getInstance())
                .build();
```

当然可自实现接口进行整理



## ProGuard

首先是Okhttp的混淆配置

```
# okhttp
-dontwarn com.squareup.okhttp.**
-keep class com.squareup.okhttp.** { *;}
-dontwarn okio.**
```

打包的时候

```
#remove Log
-assumenosideeffects class com.halcyon.logger.util.Logger{
    *;
}
```

如用自定义`com.halcyon.logger.ILogger`的实现类,替换即可