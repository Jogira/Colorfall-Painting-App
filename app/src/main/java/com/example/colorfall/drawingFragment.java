package com.example.colorfall;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class drawingFragment extends Fragment {


    public drawingFragment() {
        // Required empty public constructor
    }

//    @Override
//    public void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//        drawView drawView = new drawView(this);
//        fragment_context = container.getContext();
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //drawView drawView = new drawView(this);

        //drawView drawView = new drawView(this);
        return inflater.inflate(R.layout.fragment_drawing, container, false);
    }

}
