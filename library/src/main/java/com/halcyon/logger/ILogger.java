package com.halcyon.logger;

import android.util.Log;


public interface ILogger {


    ILogger DEFAULT = new ILogger() {

        @Override
        public void d(String tag, String msg) {
            Log.d(tag,msg);
        }

    };

    void d(String tag, String msg);


}
