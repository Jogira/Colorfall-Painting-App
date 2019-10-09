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

<<<<<<< HEAD
    public int addNum(int num1, int num2)
    {
        int result = num1 + num2;
        return result;
=======
    //git merge testing, NOT a real method we need
    public void gitMergeTesting() {
        //code :~)
        //gabe
>>>>>>> ad61ff115d421a3c37a3ca8325e1612dda8e432d
    }
}
