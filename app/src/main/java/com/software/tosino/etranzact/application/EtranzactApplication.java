package com.software.tosino.etranzact.application;

import android.app.Application;
import android.content.Context;

public class EtranzactApplication extends Application {
    private static EtranzactApplication etranzactApplication;

    public static final String TAG = EtranzactApplication.class
            .getSimpleName();

    public static Context getAppContext() {
        return etranzactApplication.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        etranzactApplication = this;
    }

    public static EtranzactApplication getBankingApplication() {
        return etranzactApplication;
    }
}
