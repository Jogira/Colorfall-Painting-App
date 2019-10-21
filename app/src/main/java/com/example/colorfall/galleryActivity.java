package com.example.colorfall;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.mindorks.placeholderview.PlaceHolderView;
//A work in progress for creating a gallery where we can view saved pictures.

public class galleryActivity extends Activity {
    private PlaceHolderView mGalleryView;

    private class galleryActivity1 extends Fragment {


        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_gallery);


        }
    }
}