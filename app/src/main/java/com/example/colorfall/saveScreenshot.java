package com.example.colorfall;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class saveScreenshot {
/*
    void saveDrawing() {
        Context context = getContext(); //is this the right context? getActivityContext()? getApplicationContext()?
        //String fileName = "/data/user/0/com.example.colorfall/files/drawing.ser";
        String fileName = context.getFilesDir().getPath() + "/drawing.ser";

        try {
            //testing
            System.out.println("file name accessable? :" + fileName);
            //saving obj to .ser file
            FileOutputStream file = new FileOutputStream(fileName);
            //testing
            System.out.println("after file line reached");
            ObjectOutputStream out = new ObjectOutputStream(file);
            System.out.println("after out decl line reached");
            out.writeObject(this);//this is where the error occurs
            System.out.println("after writeObj line reached");
            out.close();
            file.close();

            //testing
            System.out.println("end of try block reached");

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

        //saving .ser file to internal storage
        File file = new File(context.getFilesDir(), fileName);
    }
*/

    void saveScreenshot(View view, Context context) { //(View view) {
        //Context context = getContext();
        //drawView drawV = new drawView(context);
        //Bitmap bitmap = drawV.screenShot(view);

        Bitmap bitmap = screenShot(view);
        String fileName = context.getFilesDir().getPath() + "/drawing.ser";

        try {
            //testing
            System.out.println("file name accessable? :" + fileName);
            //saving obj to .ser file
            FileOutputStream file = new FileOutputStream(fileName);
            //testing
            System.out.println("after file line reached");
            ObjectOutputStream out = new ObjectOutputStream(file);
            System.out.println("after out decl line reached");
            out.writeObject(bitmap);//this is where the error occurs
            System.out.println("after writeObj line reached");
            out.close();
            file.close();

            //testing
            System.out.println("end of try block reached");

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

        //saving .ser file to internal storage
        File file = new File(context.getFilesDir(), fileName);
    }

    public Bitmap screenShot(View view) {
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);
        return bitmap;
    }
}
