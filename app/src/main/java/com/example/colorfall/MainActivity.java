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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawBtn = (Button) findViewById(R.id.drawBtn);
        drawBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openDrawScreen();
            }
        });

        galleryBtn = (Button) findViewById(R.id.galleryBtn);
        galleryBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openGalleryScreen();
            }
        });

        templatesBtn = (Button) findViewById(R.id.templatesBtn);
        templatesBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openTemplateScreen();
            }
        });

        importBtn = (Button) findViewById(R.id.importBtn);
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

    //Starts a new activity when user clicks
//    public void clickUnlock(View v)
//    {
//        Intent intent = new Intent(this,drawActivity.class);
//        startActivityForResult(intent, CONFIG_REQUEST);
//    }

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
