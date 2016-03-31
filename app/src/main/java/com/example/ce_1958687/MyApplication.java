package com.example.ce_1958687;
/*
MIT License

<<<<<<< Updated upstream
Copyright (c) 2016. Synelnyk Anastasiya
=======

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

 */


import android.app.Application;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.preference.PreferenceManager;

import java.util.Locale;

//[Comment] Wrong colors
//[Comment] Unnecessary settings button
//[Comment] Wrong text sizes
public class MyApplication extends Application {

    private SharedPreferences mSharedPreferences;
    private Locale mLocale; //[Comment] You don't need it. Just put different strings into different lang directories
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