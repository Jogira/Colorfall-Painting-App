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
    private Button drawBtn;
    private Button galleryBtn;
    private Button templatesBtn;
    private Button importBtn;



    /**********************************************************************************************
     * Method       : onCreate()
     * Description  : runs when "main activity" view is created
     *                creates button objects
     *                implements onClick() methods for each button
     *
     * Input        : savedInstanceState - Bundle - not sure what this is exactly but we need it
     * Output       : void
     *
     * Author       : Jonathan
     * Date         : 10/11/2019
     *********************************************************************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //draw button
        drawBtn = findViewById(R.id.drawBtn);
        drawBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openDrawScreen();
            }
        });

        //gallery button
        galleryBtn = findViewById(R.id.galleryBtn);
        galleryBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openGalleryScreen();
            }
        });

        //templates button
        templatesBtn = findViewById(R.id.templatesBtn);
        templatesBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openTemplateScreen();
            }
        });

        //import button
        importBtn = findViewById(R.id.importBtn);
        importBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openImportScreen();
            }
        });
    }
    private final int CONFIG_REQUEST = 123;



    public void openDrawScreen()
     {
        Intent intent = new Intent(this,  drawActivity.class);
        startActivityForResult(intent, CONFIG_REQUEST);
     }

    public void openTemplateScreen()
    {
        Intent intent = new Intent(this,  TemplatesActivity.class);
        startActivityForResult(intent, CONFIG_REQUEST);
    }

    public void openImportScreen()
    {
        Intent intent = new Intent(this,  importActivity.class);
        startActivityForResult(intent, CONFIG_REQUEST);
    }

    public void openGalleryScreen()
    {
        Intent intent = new Intent(this,  galleryActivity.class);
        startActivityForResult(intent, CONFIG_REQUEST);
    }

}
