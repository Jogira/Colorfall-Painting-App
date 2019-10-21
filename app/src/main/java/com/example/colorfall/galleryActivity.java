package com.example.colorfall;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.widget.TextView;

import com.mindorks.placeholderview.PlaceHolderView;
import android.content.Intent;



public class galleryActivity extends Activity {
    private PlaceHolderView mGalleryView;
    private String list;

    //private class galleryActivity1 extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        TextView textView = (TextView)findViewById(R.id.textView);
        TextView m = (TextView) findViewById(R.id.textView);
        TextView textView1 = (TextView)findViewById(R.id.textView);
        TextView m1 = (TextView) findViewById(R.id.textView1);
        m.setBackgroundColor(Color.BLACK);
        m.setTextColor(Color.WHITE);



        drawActivity class1 = new drawActivity();
        String list1 = class1.getFiles();


//
//            m.setText("Gallery");
//
        //mGalleryView = findViewById(R.id.galleryView);
        //mGalleryView.addView(new GalleryItem(getResources().getDrawable(R.drawable.tempicon, null)));
        Intent intent = getIntent();

        list = intent.getStringExtra("filenames");
        if(list!=null) {
            m.setText("Gallery Contents:");
            m1.setText(list);



        }
    }





    // }

}