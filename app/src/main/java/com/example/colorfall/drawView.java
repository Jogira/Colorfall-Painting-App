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
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.LinearLayout;
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
        private Path path;
        private Paint drawPixel;
        private Paint pixelCanvasPaint;
        private int currentColor = 0xFF000000;
        private Canvas drawPixelCanvas;
        private Bitmap canvasPixelBitmap;


        //constructor
        public drawView(Context context, AttributeSet attributes){
            super(context, attributes);
            initializePixelArt();
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
                case MotionEvent.ACTION_UP:
                    drawPixelCanvas.drawPath(path, drawPixel);
                    path.reset();
                    break;
                default:
                    return false;
            }
            postInvalidate();
            return true;
        }

    private void initializePixelArt()
    {
        path = new Path();
        drawPixel = new Paint();

        drawPixel.setColor(currentColor);
        drawPixel.setAntiAlias(true);
        drawPixel.setStrokeWidth(30F);
        drawPixel.setStyle(Paint.Style.STROKE);
        drawPixel.setStrokeJoin(Paint.Join.ROUND);
        drawPixel.setStrokeCap(Paint.Cap.ROUND);

        pixelCanvasPaint = new Paint(Paint.DITHER_FLAG);
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
          invalidate();
          currentColor = Color.parseColor(color);
          drawPixel.setColor(currentColor);
    }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);
            canvasPixelBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            drawPixelCanvas = new Canvas(canvasPixelBitmap);
        }

        @Override
        protected void onDraw(Canvas canvas)
        {
            canvas.drawBitmap(canvasPixelBitmap, 0, 0, pixelCanvasPaint);
            canvas.drawPath(path, drawPixel);
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
