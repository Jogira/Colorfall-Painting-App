package com.example.colorfall;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.mindorks.placeholderview.PlaceHolderView;


public class galleryActivity extends Activity {
    private PlaceHolderView mGalleryView;

    private class galleryActivity1 extends Fragment {


        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_gallery);
            mGalleryView = findViewById(R.id.galleryView);
            mGalleryView.addView(new GalleryItem(getResources().getDrawable(R.drawable.tempicon, null)));

        }




    }
}