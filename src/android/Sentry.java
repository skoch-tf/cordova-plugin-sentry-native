package com.lafourchette.plugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

public class Sentry extends CordovaPlugin {
    static String TAG = "LF_SENTRY";

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        // your init code here
        Log.i(TAG, "PLUGIN com.lafourchette.plugin.sentry INITIALIZED");

        final Thread.UncaughtExceptionHandler oldHandler = Thread.getDefaultUncaughtExceptionHandler();

        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
                // Do your own error handling here
                Log.e(TAG, "SOME ERROR OCCURED");
                Log.e(TAG, "SOME ERROR OCCUREDDDDDD");

                if (oldHandler != null)
                    oldHandler.uncaughtException(paramThread, paramThrowable); // Delegates to Android's error handling
                else
                    System.exit(2); // Prevents the service/app from freezing
            }
        });

    }
}
