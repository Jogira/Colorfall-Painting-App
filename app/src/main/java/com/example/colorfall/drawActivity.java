package com.example.colorfall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.view.View;
import android.widget.ImageButton;
import android.content.Context;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

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
    private ImageButton blueColor;
    private ImageButton yellowColor;
    private ImageButton redColor;
    private ImageButton greenColor;
    private ImageButton blackColor;
    private ImageButton eraseButton;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_draw);
        LinearLayout paintLayout = (LinearLayout)findViewById(R.id.paint_colors);
        selectedColor = (ImageButton)paintLayout.getChildAt(0);
        drawingView = (drawView) findViewById(R.id.drawing);


        blueColor = (ImageButton) findViewById(R.id.blueColor);
        blueColor.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                onSelectColor(view);
            }
        });

        redColor = (ImageButton) findViewById(R.id.redColor);
        redColor.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                onSelectColor(view);
            }
        });

        greenColor = (ImageButton) findViewById(R.id.greenColor);
        greenColor.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                onSelectColor(view);
            }
        });

        yellowColor = (ImageButton) findViewById(R.id.yellowColor);
        yellowColor.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                onSelectColor(view);
            }
        });

        blackColor = (ImageButton) findViewById(R.id.blackColor);
        blackColor.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                onSelectColor(view);
            }
        });

        eraseButton = (ImageButton) findViewById(R.id.eraser);
        eraseButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                onSelectColor(view);
            }
        });

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
<<<<<<< HEAD

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
=======
>>>>>>> 544b89f3b7033b6656c0e86616f4fbd6c586bd64
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
        Toast.makeText(getApplicationContext(), "Drawing saved...", Toast.LENGTH_SHORT).show();
        printSavedFiles();
        //testing
        ourPath path = drawingView.getPath();
        path.printList();
        //end testing
    }

    public void onClickLoad(View view) {
        load();
    }

    public void onSelectColor(View view)
    {
        if (view.getId() == blueColor.getId())
        {
            drawingView.setColor("#072F5F");
        }

        if (view.getId() == redColor.getId())
        {
            drawingView.setColor("#FFFF0000");
        }

        if (view.getId() == yellowColor.getId())
        {
            drawingView.setColor("#FFFF00");
        }

        if (view.getId() == greenColor.getId())
        {
            drawingView.setColor("#00FF3E");
        }

        if (view.getId() == blackColor.getId())
        {
            drawingView.setColor("#FF000000");
        }

        if (view.getId() == eraseButton.getId())
        {
            drawingView.setColor("#ffffff");
        }
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
