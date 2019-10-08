package com.example.colorfall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private final int CONFIG_REQUEST = 123;

    //Starts a new activity when user clicks
    public void clickUnlock(View view)
    {
        Intent intent = new Intent(this,drawActivity.class);
        startActivityForResult(intent, CONFIG_REQUEST);
    }

    public void clickUnlock(View view)
    {
        Intent intent = new Intent(this,galleryActivity.class);
        startActivityForResult(intent, CONFIG_REQUEST);
    }

    public void clickUnlock(View view)
    {
        Intent intent = new Intent(this,TemplatesActivity.class);
        startActivityForResult(intent, CONFIG_REQUEST);
    }

    public void clickUnlock(View view)
    {
        Intent intent = new Intent(this,importActivity.class);
        startActivityForResult(intent, CONFIG_REQUEST);
    }


}
