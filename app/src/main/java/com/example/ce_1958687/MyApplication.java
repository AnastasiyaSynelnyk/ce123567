package com.example.ce_1958687;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.preference.PreferenceManager;

import java.util.Locale;

/**
 * Created by Дом on 27.03.2016.
 */
public class MyApplication extends Application {

    private SharedPreferences mSharedPreferences;
    private Locale mLocale;
    private String mLang;

    @Override
    public void onCreate() {

        mSharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        mLang = mSharedPreferences.getString("lang", "default");
        if(mLang.equals("default")) {
            mLang = getResources().getConfiguration().locale.getCountry();
        }
          mLocale = new Locale(mLang);
            Configuration mConfiguration = new Configuration();
            mConfiguration.locale = mLocale;
            getBaseContext().getResources().updateConfiguration(mConfiguration, null);
           super.onCreate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mLocale = new Locale(mLang);
        Locale.setDefault(mLocale);
        Configuration mConfig = new Configuration();
        mConfig.locale = mLocale;
        getBaseContext().getResources().updateConfiguration(mConfig, null);
    }
}
