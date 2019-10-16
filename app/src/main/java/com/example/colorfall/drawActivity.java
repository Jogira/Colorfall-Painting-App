package com.example.colorfall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;



//this is the VIew in Model-View-Controller architecture
public class drawActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        drawView drawView = new drawView(this);
        setContentView(R.layout.activity_draw);
    }
        //brush.setColor(Color.BLUE);
        //brush.setColor(Color.BLUE);
        //brush.setStyle(Paint.Style.STROKE);
        //brush.setStrokeJoin(Paint.Join.ROUND);
        //brush.setStrokeWidth(100f);
    //Detect button press of color selector
    public void colorSel(View view)
    {

    }


    public void onClickSave (View view) {
        drawView drawView = new drawView(this);
        drawView.saveDrawing();
    }
}
