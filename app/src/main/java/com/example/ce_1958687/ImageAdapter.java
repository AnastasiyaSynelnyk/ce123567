/*
MIT License

Copyright (c) 2016. Synelnyk Anastasiya

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
package com.example.ce_1958687;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> { 

    private Context mContext;

    private String[] myDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {

       private ImageView mImageFashion; 

        public ViewHolder(View imageView) {
            super(imageView);
            this.mImageFashion = (ImageView) imageView.findViewById(R.id.image_view_fashion);

        }
    }

    public ImageAdapter(Context context, String[] myDataSet) {
        this.mContext = context; 
        this.myDataSet = myDataSet;
    }

    @Override
    public ImageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_view, parent, false);

        ViewHolder mViewHolder = new ViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(ImageAdapter.ViewHolder holder, int position) {
        Picasso.with(mContext)
                .load(myDataSet[position])
                .into(holder.mImageFashion);

    }

    @Override
    public int getItemCount() {
        return myDataSet.length;
    }
}
