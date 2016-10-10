package com.example.interceptor.utils;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;

import com.example.interceptor.BuildConfig;
import com.halcyon.logger.ILogger;


public class Logger implements ILogger {

    public static final boolean isDebug = BuildConfig.DEBUG;

    public static String Tag = "Halcyon";

    public static void setTag(String tag) {
        Logger.Tag = tag;
    }

    private static Logger mLogger = new Logger();

    public StackTraceElement getCallerStackTraceElement() {
        return Thread.currentThread().getStackTrace()[4];
    }

    private Logger() {

    }

    public static Logger getInstance(){
        return mLogger;
    }

    @SuppressLint("DefaultLocale")
    private String generateTag(StackTraceElement caller) {
        String tag = "%s.%s(Line:%d)";
        String callerClazzName = caller.getClassName();
        callerClazzName = callerClazzName.substring(callerClazzName.lastIndexOf(".") + 1);
        tag = String.format(tag, callerClazzName, caller.getMethodName(), caller.getLineNumber());
        tag = TextUtils.isEmpty(Tag) ? tag : Tag + ":" + tag;
        return tag;
    }


    @Override
    public String trace() {
        return generateTag(getCallerStackTraceElement());
    }


    public static void v(String msg) {
        mLogger
                .v(Tag,mLogger.trace())
                .v(Tag, msg);
    }

    public static void d(String msg) {
        mLogger
                .d(Tag,mLogger.trace())
                .d(Tag, msg);
    }

    public static void i(String msg) {
        mLogger
                .i(Tag,mLogger.trace())
                .i(Tag, msg);
    }

    public static void w(String msg) {
        mLogger
                .w(Tag,mLogger.trace())
                .w(Tag, msg);
    }

    public static void e(String msg) {
        mLogger
                .e(Tag,mLogger.trace())
                .e(Tag, msg);
    }

    public static void wtf(String msg) {
        mLogger
                .wtf(Tag,mLogger.trace())
                .wtf(Tag, msg);
    }

    @Override
    public ILogger v(String tag, String msg) {
        if (!isDebug) return null;
        Log.v(Tag, msg);
        return this;
    }

    @Override
    public ILogger d(String tag, String msg) {
        if (!isDebug) return null;
        Log.d(Tag, msg);
        return this;
    }

    @Override
    public ILogger i(String tag, String msg) {
        if (!isDebug) return null;
        Log.i(Tag, msg);
        return this;
    }

    @Override
    public ILogger w(String tag, String msg) {
        if (!isDebug) return null;
        Log.w(Tag, msg);
        return this;
    }

    @Override
    public ILogger e(String tag, String msg) {
        if (!isDebug) return null;
        Log.e(Tag, msg);
        return this;
    }

    @Override
    public ILogger wtf(String tag, String msg) {
        if (!isDebug) return null;
        Log.wtf(Tag, msg);
        return this;
    }
}
