package com.example.colorfall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//this is the VIew in Model-View-Controller architecture
public class drawActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        drawView drawView = new drawView(this);
        setContentView(drawView);

        //save button instantiate
        Button saveBtn = findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener()//this whole thing runs onClickSave() when save button is clicked
        {
            @Override
            public void onClick(View v)
            {
                onClickSave();
            }
        });

    }

    public void onClickSave() { //tells controller to save start save proccess of the drawing on the draw screen
        drawView drawView = new drawView(this);
        drawView.saveDrawing();
    }


}
