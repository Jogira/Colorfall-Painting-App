package com.example.colorfall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.ImageButton;
import android.content.Context;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;


//this is the View in Model-View-Controller architecture
public class drawActivity extends AppCompatActivity implements java.io.Serializable
{
    private ArrayList<Integer> colors = new ArrayList<>();
    private drawView drawingView;
    private ImageButton selectedColor;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_draw);
        LinearLayout paintLayout = (LinearLayout)findViewById(R.id.paint_colors);
        selectedColor = (ImageButton)paintLayout.getChildAt(0);
        drawingView = (drawView) findViewById(R.id.drawing);

       // selectedColor.setImageDrawable(getDrawable(R.drawable.paint_selected));



        //temp testing while save button DNE
        //drawView drawVie = new drawView(this);
        //drawVie.saveDrawing();
        //drawView drawV = new drawView(this);
        //drawV.printSavedFiles();
        //above is testing while save btn DNE

        //drawView drawView = new drawView(this);
        //setContentView(drawView);

        //colorData(); //Calls and creates color items for brush
    }

    public void colorChanged(View view)
    {
        if(view != selectedColor)
        {
            ImageButton imgView = (ImageButton) view;
            String color = view.getTag().toString();
            drawingView.setColor(color);
        }
    }

    public Context getOurContext() {
        Context context = getApplicationContext();
        return context;
    }
        //brush.setColor(Color.BLUE);
        //brush.setColor(Color.BLUE);
        //brush.setStyle(Paint.Style.STROKE);
        //brush.setStrokeJoin(Paint.Join.ROUND);
        //brush.setStrokeWidth(100f);

//    //Colors for brush
//    private void colorData()
//    {
//        colors.add(R.color.colorPrimary, 1);
//        colors.add(R.color.colorPrimary, 2);
//        //colors.add("Green");
//        //colors.add("Amber");
//       // colors.add("Deep Orange");
//
//       // createRV();
//    }

//    //Instantiates a recyclerview
//    private void createRV()
//    {
//        RecyclerView recyclerView = findViewById(R.id.cList);  //Link to XML description
//        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, colors); //sends item data
//        recyclerView.setAdapter(adapter); //Sets adapter to recyclerview
//        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //start linear recycleView
//    }

    //onCLick method for save button
    public void onClickSave (View view) {
        save();
        printSavedFiles();
        //testing
        ourPath path = drawingView.getPath();
        path.printList();
        //end testing
    }

    public void onClickLoad(View view) {
        load();
    }

    public void onClickBlue(View view) {
        String blue = "blue";
        drawingView.setColor(blue);
    }

    public void save() {
        Context context = getApplicationContext();
        String fileName = context.getFilesDir().getPath() + "/drawing.ser";

        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(drawingView.getPath());
            out.close();
            file.close();
            System.out.println("end of try block reached");//testing

        } catch (Exception ex) {
            System.out.println("Exception is caught");
        }

        //saving .ser file to internal storage
        File file = new File(context.getFilesDir(), fileName);
    }

    void printSavedFiles() {
        Context context = getApplicationContext();
        System.out.println(context.getFilesDir().getAbsolutePath());
        String[] fList = context.fileList();
        System.out.println(Arrays.toString(fList) + "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    }

    public void load() {
        //setup
        Context context = getApplicationContext();//if errors occur down the road, its likely from this
        String fileName = context.getFilesDir().getPath() + "/drawing.ser";
        ourPath path = drawingView.getPath();

        //loading
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            path.readObject(ois);//error occuring here
            ois.close();
        } catch (Exception e) {
            System.out.println("error boiiiii");//testing
            e.printStackTrace();
        }
    }

}
