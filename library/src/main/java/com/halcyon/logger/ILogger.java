package com.halcyon.logger;

import android.util.Log;

public interface ILogger {

    String TAG = "Halcyon";

    ILogger DEFAULT = new ILogger() {

        @Override
        public void log(String msg) {
            Log.i(TAG,msg);
        }
    };

    void log(String msg);

}
