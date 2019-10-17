package com.example.colorfall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

<<<<<<< HEAD
import android.content.Context;
=======
import android.app.Activity;
>>>>>>> 53a76c63316daba8930f736d5a85d47b6ec0142d
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

<<<<<<< HEAD
        //temp testing while save button DNE
        //drawView drawVie = new drawView(this);
        //drawVie.saveDrawing();
        //drawView drawV = new drawView(this);
        //drawV.printSavedFiles();
        //above is testing while save btn DNE

=======
        drawView drawView = new drawView(this);
        setContentView(R.layout.activity_draw);
>>>>>>> 53a76c63316daba8930f736d5a85d47b6ec0142d
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
