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

```xml
<dependency>
  <groupId>com.lhalcyon</groupId>
  <artifactId>okhttp-logger-interceptor</artifactId>
  <version>1.0.2</version>
  <type>pom</type>
</dependency> 
```

或者 通过Gradle

```groovy
compile 'com.lhalcyon:okhttp-logger-interceptor:1.0.2'
```



## Usage

```java
 OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HttpLogInterceptor()) 
                .build();
```

无参构造默认使用的是`android.util.Log` .对于有日志开关需求的,可以传入一个`com.halcyon.logger.ILogger`的实现类.`LogUtils`是[Sample](https://github.com/lhalcyon/okhttp-logger-interceptor/tree/master/sample)中的自定义日志工具类,开关为`BuildConfig.DEBUG`

```java
OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HttpLogInterceptor(new ILogger() {
                    @Override
                    public void d(String tag, String msg) {
                        //自定义的日志类
                        LogUtils.d(msg);
                    }
                }))
                .build();
```

## ProGuard

首先是Okhttp的混淆配置

```
# okhttp
-dontwarn com.squareup.okhttp.**
-keep class com.squareup.okhttp.** { *;}
-dontwarn okio.**
```

再就是如果有自定义工具类,打包的时候需要将自定义的日志类的开关置false,然后

```
#remove Log
-assumenosideeffects class [自定义的日志类如Sample中的(com.example.interceptor.utils.LogUtils)]{
    *;
}
```

