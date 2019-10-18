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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
        Context context = getApplicationContext(); //is this the right context? getActivityContext()? getApplicationContext()?
        //String fileName = "/data/user/0/com.example.colorfall/files/drawing.ser";
        String fileName = context.getFilesDir().getPath() + "/brawing.ser";

        try {
            //testing
            System.out.println("file name accessable? :" + fileName);
            //saving obj to .ser file
            FileOutputStream file = new FileOutputStream(fileName);
            //testing
            System.out.println("after file line reached");
            ObjectOutputStream out = new ObjectOutputStream(file);
            System.out.println("after out decl line reached");
            //out.writeObject(drawingView);//this is where the error occurs
            //out.writeObject(fileName); this for ex does not throw error
            out.writeObject(drawingView.getPath());
            System.out.println("after writeObj line reached");
            out.close();
            file.close();
            //testing
            System.out.println("end of try block reached");

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

}
