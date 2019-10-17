package com.example.colorfall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.text.Layout;
import android.view.ContextMenu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

import java.io.*;
import java.util.Arrays;

//this is the Controller in view-controller-module architecture
/**********************************************************************************************
 * Description  : Setting the default details for the brush type, the size of the brush
 *                and how it looks. Also specifies how the app functions if you hold you
 *                touch the screen to draw.
 *
 *                I'll have to fill in more on this later, I still have to figure out how to
 *                allow the size of the canvas to be changed.
 *
 *
 *
 * Author       : Jonathan
 * Date         : 10/13/2019
 *********************************************************************************************/

public class drawView extends View implements Serializable
{
    LayoutParams params;
    private Path path = new Path();
    private Paint brush = new Paint();

    //constructor
    public drawView(Context context)
    {
        super(context);

        brush.setAntiAlias(true);
        brush.setColor(Color.BLUE);
        brush.setStyle(Paint.Style.STROKE);
        brush.setStrokeJoin(Paint.Join.ROUND);
        brush.setStrokeWidth(100f);

        params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        //temp testing while save button DNE
        //saveDrawing();
        //printSavedFiles();
        //above is testing while save btn DNE

        float pointX = event.getX();
        float pointY = event.getY();

        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(pointX, pointY);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(pointX, pointY);
                break;
            default:
                return false;
        }
        postInvalidate();
        return false;
    }

    /***********************************************************************************************
     *  Method : setColor()
     *  Description: sets brush color parameter
     *
     *  Notes:
     *
     **********************************************************************************************/
    //Color Setter method
    public void setColor(String color)
    {
          brush.setColor(Color.parseColor(color));
    }


    @Override
    protected void onDraw(Canvas canvas)
    {
        canvas.drawPath(path, brush);
    }


    /***********************************************************************************************
     *  Method : saveDrawing()
     *  Description: saves current state of this class into internal file system.
     *
     *  Notes: uses serializable to convert current state of obj to a file "drawing.ser"
     *         saves this created file into internal memory
     *         not sure if it works yet, will be easier to check when save button is accessible
     *
     *
     **********************************************************************************************/
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

    void printSavedFiles() {
        Context context = getContext();
        System.out.println(context.getFilesDir().getAbsolutePath());
        String[] fList = context.fileList();
        System.out.println(Arrays.toString(fList) + "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    }

    public Bitmap screenShot(View view) {
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);
        return bitmap;
    }
}
