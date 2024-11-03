package com.widget.testhsm.support;

import android.util.Log;

import com.widget.testhsm.interfaces.ILogger;

public class Logger extends ILogger {

    final String TAG = "hsm";

    @Override
    public void print(String string) {
        Log.d(TAG, string);
    }

    @Override
    public void clear() {

    }
}
