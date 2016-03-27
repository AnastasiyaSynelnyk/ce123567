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


import android.app.ActionBar;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.provider.SyncStateContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    View.OnClickListener mOnClickListener; //[Comment] Unused
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));

        Resources mRes = getResources();
        String[] models = mRes.getStringArray(R.array.models_array);

        mAdapter = new MyAdapter(getBaseContext(), models);

        mRecyclerView.setAdapter(mAdapter);


        TextView mTextViewFashWeek = (TextView) findViewById(R.id.paris_fashion_week_view);
        mTextViewFashWeek.setClickable(true);
        mTextViewFashWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast mToast = Toast.makeText(getApplicationContext(), "Title", Toast.LENGTH_LONG);

                mToast.show();
                mToast.setGravity(Gravity.CENTER, 10, 10);

            }
        });

        TextView textViewStart = (TextView) findViewById(R.id.start_show);
        textViewStart.setClickable(true);
        textViewStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast mToast = Toast.makeText(getApplicationContext(), "Start show", Toast.LENGTH_LONG);
                mToast.show();
                mToast.setGravity(Gravity.CENTER, 10, 10);
            }
        });

        TextView textViewStarData = (TextView) findViewById(R.id.str_data);
        textViewStarData.setClickable(true);
        textViewStarData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast mToast = Toast.makeText(getApplicationContext(), "Date start", Toast.LENGTH_LONG);
                mToast.show();
                mToast.setGravity(Gravity.CENTER, 10, 10);
            }
        });

        TextView textViewFin = (TextView) findViewById(R.id.fin_label);
        textViewFin.setClickable(true);
        textViewFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast mToast = Toast.makeText(getApplicationContext(), "Finish point", Toast.LENGTH_LONG);
                mToast.show();
                mToast.setGravity(Gravity.CENTER, 10, 10);
            }
        });


        TextView textViewFinDate = (TextView) findViewById(R.id.fin_data);
        textViewFinDate.setClickable(true);
        textViewFinDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast mToast = Toast.makeText(getApplicationContext(), "Finish date of the show ", Toast.LENGTH_LONG);
                mToast.show();
                mToast.setGravity(Gravity.CENTER, 10, 10);
            }
        });


        TextView textViewState = (TextView) findViewById(R.id.text_state);
        textViewState.setClickable(true);
        textViewState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast  mToast = Toast.makeText(getApplicationContext(), "Text, displaying current state", Toast.LENGTH_LONG);
                mToast.show();
                mToast.setGravity(Gravity.CENTER, 10, 10);

            }
        });

        TextView textViewDesigner = (TextView) findViewById(R.id.designer);
        textViewDesigner.setClickable(true);
        textViewDesigner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast mToast = Toast.makeText(getApplicationContext(), "Designer's name", Toast.LENGTH_LONG);
                mToast.show();
                mToast.setGravity(Gravity.CENTER, 10, 10);

            }
        });


        TextView textViewStockholm = (TextView) findViewById(R.id.stockholm);
        textViewStockholm.setClickable(true);
        textViewStockholm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast mToast = Toast.makeText(getApplication(), "City", Toast.LENGTH_LONG);
                mToast.show();
                mToast.setGravity(Gravity.CENTER, 10, 10);

            }
        });


        TextView textViewChannel = (TextView) findViewById(R.id.channel_show);
        textViewChannel.setClickable(true);
        textViewChannel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast mToast = Toast.makeText(getApplicationContext(), "Created by brend", Toast.LENGTH_LONG);
                mToast.show();
                mToast.setGravity(Gravity.CENTER, 10, 10);
            }
        });

        TextView textViewCouture = (TextView) findViewById(R.id.spring_coutre);
        textViewCouture.setClickable(true);
        textViewCouture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast mToast = Toast.makeText(getApplicationContext(), "Show attribute", Toast.LENGTH_LONG);
                //[Comment] 1. Copy/paste code. Make one method. 2. Wrong info. You should show control name
                mToast.show();
                mToast.setGravity(Gravity.CENTER, 10, 10); //[Comment] Magic numbers
            }
        });


    }
        public RecyclerView.LayoutParams generateDefaultLayoutParams() { //[Comment] Unused method. Wrong formatting
            return new RecyclerView.LayoutParams(
                    RecyclerView.LayoutParams.WRAP_CONTENT,
                    RecyclerView.LayoutParams.WRAP_CONTENT);
        }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu); //[Comment] You don't need this
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            //[Comment] You don't need this
        }
        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }


}

