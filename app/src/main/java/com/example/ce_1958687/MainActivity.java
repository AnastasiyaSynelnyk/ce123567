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


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onStart() {
        super.onStart();
        makingToasts(this);

    }

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

        mAdapter = new ImageAdapter(getBaseContext(), models);

        mRecyclerView.setAdapter(mAdapter);
    }

    private void makingToasts(MainActivity activity) {

        TextView mTextViewFashWeek = (TextView) findViewById(R.id.paris_fashion_week_view);
        mTextViewFashWeek.setOnClickListener(this);

        TextView mTextView = (TextView) findViewById(R.id.start_show);
        mTextView.setOnClickListener(this);

        TextView mstr_data = (TextView) findViewById(R.id.str_data);
        mstr_data.setOnClickListener(this);

        TextView mTextViewFin = (TextView) findViewById(R.id.fin_label);
        mTextViewFin.setOnClickListener(this);


        TextView mTextViewFinDate = (TextView) findViewById(R.id.fin_data);
        mTextViewFinDate.setOnClickListener(this);

        TextView mTextViewState = (TextView) findViewById(R.id.text_state);
        mTextViewState.setOnClickListener(this);

        TextView mTextViewDesigner = (TextView) findViewById(R.id.designer);
        mTextViewDesigner.setOnClickListener(this);

        TextView mTextViewStockholm = (TextView) findViewById(R.id.stockholm);
        mTextViewStockholm.setOnClickListener(this);


        TextView mTextViewChannel = (TextView) findViewById(R.id.channel_show);
        mTextViewChannel.setOnClickListener(this);

        TextView mTextViewCouture = (TextView) findViewById(R.id.spring_coutre);
        mTextViewCouture.setOnClickListener(this);

        TextView mFashionRunway = (TextView) findViewById(R.id.fashion_runway);
        mFashionRunway.setOnClickListener(this);


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            Toast.makeText(getApplicationContext(), item.getClass().getSimpleName(), Toast.LENGTH_LONG).show();
            finish();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {

        Toast.makeText(getApplicationContext(), v.getClass().getSimpleName(), Toast.LENGTH_SHORT).show();

    }

}
