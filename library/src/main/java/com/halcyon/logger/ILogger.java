package com.halcyon.logger;

import android.util.Log;

/**
 * ©2016-2017 kmhealthcloud.All Rights Reserved <p/>
 * Created by: L  <br/>
 * Description:
 */
public interface ILogger {

    /**
     * A {@link ILogger} defaults output appropriate for the current platform.
     */
    ILogger DEFAULT = new ILogger() {
        @Override
        public String trace() {
            return null;
        }

        @Override
        public ILogger v(String tag, String msg) {
            Log.v(tag,msg);
            return this;
        }

        @Override
        public ILogger d(String tag, String msg) {
            Log.d(tag,msg);
            return this;
        }

        @Override
        public ILogger i(String tag, String msg) {
            Log.i(tag,msg);
            return this;
        }

        @Override
        public ILogger w(String tag, String msg) {
            Log.w(tag,msg);
            return this;
        }

        @Override
        public ILogger e(String tag, String msg) {
            Log.e(tag,msg);
            return this;
        }

        @Override
        public ILogger wtf(String tag, String msg) {
            Log.wtf(tag,msg);
            return this;
        }
    };

    String trace();

    ILogger v(String tag, String msg);

    ILogger d(String tag, String msg);

    ILogger i(String tag, String msg);

    ILogger w(String tag, String msg);

    ILogger e(String tag, String msg);

    ILogger wtf(String tag, String msg);

}
