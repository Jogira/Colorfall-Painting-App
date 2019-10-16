package com.example.colorfall;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter {

    private static final String TAG= "recyclerViewAdapter";

    public class viewHolder extends RecyclerView.ViewHolder {  //ViewHolder is a lib

        ImageView image;
        RelativeLayout parentLayout;

        public viewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);
            parentLayout = itemView.findViewById(R.id.parent_layout)
        }
    }
}
