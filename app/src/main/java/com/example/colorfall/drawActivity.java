package com.example.colorfall;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.content.Intent;


import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import yuku.ambilwarna.AmbilWarnaDialog;


//this is a View in Model-View-Controller architecture
public class drawActivity extends AppCompatActivity implements java.io.Serializable {

    private drawView drawingView;
    private ImageButton selectedColor;
    private ImageButton blueColor;
    private ImageButton yellowColor;
    private ImageButton redColor;
    private ImageButton greenColor;
    private ImageButton blackColor;
    private ImageButton eraseButton;
    private ImageButton drawButton;
    private ImageButton wipeCanvas;
    private ImageButton newColors;
    private ImageButton saveButton;
    private Button loadButton;
    int DefaultColor;
    //testing save file -> gallery
    private String files;
    private String file_name = "";

    //WORK IN PROGRESS//
    //private static final String TAG = "drawActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_draw);
        LinearLayout paintLayout = (LinearLayout) findViewById(R.id.paint_colors);
        selectedColor = (ImageButton) paintLayout.getChildAt(0);
        drawingView = (drawView) findViewById(R.id.drawing);


        blueColor = (ImageButton) findViewById(R.id.blueColor);
        blueColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSelectColor(view);
            }
        });

        saveButton = (ImageButton) findViewById(R.id.save_file);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickSave(view);
            }
        });

        loadButton = findViewById(R.id.load_file);
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickLoad(view);
            }
        });

        redColor = (ImageButton) findViewById(R.id.redColor);
        redColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSelectColor(view);
            }
        });

        greenColor = (ImageButton) findViewById(R.id.greenColor);
        greenColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSelectColor(view);
            }
        });

        yellowColor = (ImageButton) findViewById(R.id.yellowColor);
        yellowColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSelectColor(view);
            }
        });

        blackColor = (ImageButton) findViewById(R.id.blackColor);
        blackColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSelectColor(view);
            }
        });

        wipeCanvas = (ImageButton) findViewById(R.id.delete_canvas);
        wipeCanvas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSelectColor(view);
            }
        });

        eraseButton = (ImageButton) findViewById(R.id.eraser);
        eraseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSelectColor(view);
            }
        });

        drawButton = (ImageButton) findViewById(R.id.pixel_pen);
        drawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSelectColor(view);
            }
        });

        newColors = (ImageButton) findViewById(R.id.new_colors);
        newColors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorWheel(false);
            }
        });
    }

//WORK IN PROGRESS//
//    public void colorChanged(View view)
//    {
//        if(view != selectedColor)
//        {
//            ImageButton imgView = (ImageButton) view;
//            String color = view.getTag().toString();
//            drawingView.setColor(color);
//        }
//    }
//
//    public Context getOurContext() {
//        Context context = getApplicationContext();
//        return context;
//    }

    //Sets vales based on btn press
    public void onSelectColor(View view) {
        if (view.getId() == blueColor.getId()) {
            drawingView.setColor("#072F5F");
            //Log.v(TAG,"color now blue" + blueColor);  //May not need for test

            //Used for Espresso test
            Toast T = Toast.makeText(this, "Blue selected.", Toast.LENGTH_SHORT);
            T.show();
        }

        if (view.getId() == redColor.getId()) {
            drawingView.setColor("#FFFF0000");

            //Used for Espresso test
            Toast T = Toast.makeText(this, "Red selected.", Toast.LENGTH_SHORT);
            T.show();
        }

        if (view.getId() == yellowColor.getId()) {
            drawingView.setColor("#FFFF00");

            //Used for Espresso test
            Toast T = Toast.makeText(this, "Yellow selected.", Toast.LENGTH_SHORT);
            T.show();
        }

        if (view.getId() == greenColor.getId()) {
            drawingView.setColor("#00FF3E");

            //Used for Espresso test
            Toast T = Toast.makeText(this, "Green selected.", Toast.LENGTH_SHORT);
            T.show();
        }

        if (view.getId() == blackColor.getId()) {
            drawingView.setColor("#FF000000");

            //Used for Espresso test
            Toast T = Toast.makeText(this, "Black selected.", Toast.LENGTH_SHORT);
            T.show();
        }

        if (view.getId() == eraseButton.getId()) {
            drawingView.setColor("#ffffff");

            //Used for Espresso test
            Toast T = Toast.makeText(this, "Eraser selected.", Toast.LENGTH_SHORT);
            T.show();
        }

        if (view.getId() == drawButton.getId()) {
            drawingView.setColor("#FF000000");

            //Used for Espresso test
            Toast T = Toast.makeText(this, "Draw selected.", Toast.LENGTH_SHORT);
            T.show();
        }

        if (view.getId() == wipeCanvas.getId()) {
            //Delete canvas
            AlertDialog.Builder newDialog = new AlertDialog.Builder(this);
            newDialog.setTitle("           Would you like to restart?");
            newDialog.setPositiveButton("[Delete Canvas]", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    drawingView.wipeCanvas();
                    dialog.dismiss();
                }
            });
            newDialog.setNegativeButton("[Continue]", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            newDialog.show();

        }
    }

    public void save() {
        Context context = getApplicationContext();
        String fileName = context.getFilesDir().getPath() + "/drawing.ser";
        //OURRPATHTEST.testinhjt();
        drawingView.getPath().save(fileName);

        File file = new File(fileName);
        if (file.exists()) {
            double bytes = file.length();
            Log.d("TAG", "bytes: " + bytes);
        } else {
            Log.d("TAG", "file does not exist");
        }
    }

    public void ColorWheel(boolean AlphaSupport)
    {
        AmbilWarnaDialog ambilWarnaDialog = new AmbilWarnaDialog(this, DefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                DefaultColor = color;
                String colorStr= "#"+Integer.toHexString(color);
                drawingView.setColor(colorStr);
            }
        });
        ambilWarnaDialog.show();
    }
    void printSavedFiles() {
        Context context = getApplicationContext();
        System.out.println(context.getFilesDir().getAbsolutePath());
        String[] fList = context.fileList();
        System.out.println(Arrays.toString(fList) + "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        Log.d("TAG", "files:" + Arrays.toString(fList));
        files+=Arrays.toString(fList) + "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n";
        //code for gallery

        //Intent intent = new Intent(this, galleryActivity.class);
        //intent.putExtra("filenames", files);
        //startActivity(intent);


    }

    public String getFiles(){
        return files;
    }

//WORK IN PROGRESS//
    public void load() {
        //setup
        Context context = getApplicationContext();//if errors occur down the road, its likely from this
        String fileName = context.getFilesDir().getPath() + "/drawing.ser";

        //check if file existss and is non empty
        File file = new File(fileName);

        if(file.exists()) {
            double bytes = file.length();
            Log.d("TAG", "bytes: " + bytes);
        } else {
            Log.d("TAG", "file does not exist");
        }

        drawingView.getPath().load(fileName);
    }

    //onCLick method for save button
    public void onClickSave (View view) {
        save();
        Toast.makeText(getApplicationContext(), "Drawing saved...", Toast.LENGTH_SHORT).show();


        printSavedFiles();
        //testing
        ourPath path = drawingView.getPath();
        path.printList();
        //end testing

        //sending file names to gallery

    }

    public void onClickLoad(View view) {
        load();
        //Intent intent = new Intent(this,  galleryActivity.class);
        //startActivity(intent);
    }
}
