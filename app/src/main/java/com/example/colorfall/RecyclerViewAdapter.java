package com.example.colorfall;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final String TAG= "recyclerViewAdapter";
    private ArrayList<Integer> ColorValues = new ArrayList<>();
    private Context myContext;

    //Default constructor
    public RecyclerViewAdapter(Context Context, ArrayList<Integer> cVal) {
        ColorValues = cVal;
        myContext = Context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_color,
                parent, false);
        RecyclerView.ViewHolder holder = new viewHolder(view); //Creates obj of viewHolder class
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called"); //Log for debugging

       // holder.colorValue.setColorFilter(ColorValues.get(position));

       // holder.parentLayout.setOnCLickListner(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//        }
//            //call brush setter here !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//        });

    }

    @Override
    public int getItemCount() {
        return ColorValues.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {  //.ViewHolder is a lib

        //TextView colorName
        ImageView colorValue;
        RelativeLayout parentLayout;

        public viewHolder(View itemView) {
            super(itemView);
            colorValue = itemView.findViewById(R.id.imageView);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
