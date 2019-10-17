package com.example.colorfall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Context;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;


//this is the VIew in Model-View-Controller architecture
public class drawActivity extends AppCompatActivity
{
    private ArrayList<Integer> colors = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //temp testing while save button DNE
        //drawView drawVie = new drawView(this);
        //drawVie.saveDrawing();
        //drawView drawV = new drawView(this);
        //drawV.printSavedFiles();
        //above is testing while save btn DNE

        drawView drawView = new drawView(this);
        setContentView(R.layout.activity_draw);

        colorData(); //Calls and creates color items for brush
    }
        //brush.setColor(Color.BLUE);
        //brush.setColor(Color.BLUE);
        //brush.setStyle(Paint.Style.STROKE);
        //brush.setStrokeJoin(Paint.Join.ROUND);
        //brush.setStrokeWidth(100f);

    //Colors for brush
    private void colorData()
    {
        colors.add(R.color.colorPrimary, 1);
        colors.add(R.color.colorPrimary, 2);
        //colors.add("Green");
        //colors.add("Amber");
       // colors.add("Deep Orange");

        createRV();
    }

    //Instantiates a recyclerview
    private void createRV()
    {
        RecyclerView recyclerView = findViewById(R.id.cList);  //Link to XML description
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, colors); //sends item data
        recyclerView.setAdapter(adapter); //Sets adapter to recyclerview
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //start linear recycleView
    }

    public void onClickSave (View view) {
        //drawView drawView = new drawView(this);
        //drawView.saveDrawing();

        Context context = getApplicationContext();
        saveScreenshot saveSc = new saveScreenshot();
        saveSc.saveScreenshot(view, context);
    }

}
