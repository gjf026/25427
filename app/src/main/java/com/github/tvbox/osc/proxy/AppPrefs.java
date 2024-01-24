package com.github.tvbox.osc.proxy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class AppPrefs {
    private static final String TAG = AppPrefs.class.getSimpleName();
    @SuppressLint("StaticFieldLeak")
    private static AppPrefs sInstance;
    private static final String WEB_PROXY_URI = "web_proxy_uri";
    private static final String WEB_PROXY_ENABLED = "web_proxy_enabled";

    private SharedPreferences mSharedPreferences;

    private AppPrefs(Context context) {
        mSharedPreferences = context.getSharedPreferences("proxy", Context.MODE_PRIVATE);
    }

    public static AppPrefs instance(Context context) {
        if (sInstance == null) {
            sInstance = new AppPrefs(context.getApplicationContext());
        }

        return sInstance;
    }

    public String getWebProxyUri() {
        return mSharedPreferences.getString(WEB_PROXY_URI, "");
    }

    public void setWebProxyUri(String uri) {
        mSharedPreferences.edit().putString(WEB_PROXY_URI, uri).apply();
    }

    public boolean isWebProxyEnabled() {
        boolean enabled = mSharedPreferences.getBoolean(WEB_PROXY_ENABLED, false);
        return enabled;
    }

    public void setWebProxyEnabled(boolean enabled) {
        mSharedPreferences.edit().putBoolean(WEB_PROXY_ENABLED, enabled).apply();
    }
}
