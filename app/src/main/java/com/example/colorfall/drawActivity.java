package com.example.colorfall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
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

        //temp testing while save button DNE
        //drawView drawVie = new drawView(this);
        //drawVie.saveDrawing();
        //drawView drawV = new drawView(this);
        //drawV.printSavedFiles();
        //above is testing while save btn DNE

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
        //drawView drawView = new drawView(this);
        //drawView.saveDrawing();

        Context context = getApplicationContext();
        saveScreenshot saveSc = new saveScreenshot();
        saveSc.saveScreenshot(view, context);
    }

}
