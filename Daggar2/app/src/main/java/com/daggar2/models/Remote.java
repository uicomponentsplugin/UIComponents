package com.daggar2.models;

import android.util.Log;

import javax.inject.Inject;

public class Remote {
    private static final String TAG = "Remote";

    @Inject
    public Remote() {
    }

    public void setListener() {
        Log.d(TAG, "setListener: Connected");
    }
}
