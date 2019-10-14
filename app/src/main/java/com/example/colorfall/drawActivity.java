package com.example.colorfall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class drawActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        drawView drawView = new drawView(this);
        setContentView(drawView);
    }

}
