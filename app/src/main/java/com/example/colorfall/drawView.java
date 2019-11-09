package com.example.colorfall;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.io.Serializable;

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
        //private Path path;//commented for new path
        private ourPath path;
        private static Paint drawPixel;                //Our brush object
        private Paint gridLines;
        private Paint pixelCanvasPaint;
        private int currentColor = 0xFF000000;
        private int pickedColor = 0xFF000000;
        private Canvas drawPixelCanvas;
        public static Bitmap canvasPixelBitmap;
        static String hexValuePicked = "#0";
        static int pixel;
        static int redValue;
        static int blueValue;
        static int greenValue;
        static float pointX;
        static float pointY;




        //constructor
        public drawView(Context context, AttributeSet attributes)
        {
            super(context, attributes);
            initializePixelArt();
        }

        @Override
        public boolean onTouchEvent(MotionEvent event)
        {


             pointX = event.getX();
             pointY = event.getY();


            switch(event.getAction())
            {
                case MotionEvent.ACTION_DOWN:
                    path.moveTo(pointX, pointY);

                    pixel = canvasPixelBitmap.getPixel((int) pointX, (int) pointY);
                    if(pointX > 0 && pointY > 0 && drawActivity.pickerClicked == true)
                    {
                        redValue = Color.red(pixel);
                        blueValue = Color.blue(pixel);
                        greenValue = Color.green(pixel);
                        drawPixel.setColor(pixel);
                        drawActivity.pickerClicked = false;
                    }

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
        path = new ourPath();
        gridLines = new Paint();
        drawPixel = new Paint();

        gridLines.setColor(Color.BLACK);
        gridLines.setStrokeWidth(1F);
        drawPixel.setColor(currentColor);
        drawPixel.setAntiAlias(false);
        drawPixel.setStrokeWidth(70F);
        drawPixel.setStyle(Paint.Style.STROKE);
        drawPixel.setStrokeJoin(Paint.Join.MITER);
        drawPixel.setStrokeCap(Paint.Cap.SQUARE);

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

    public void wipeCanvas()
    {
        drawPixelCanvas.drawColor(Color.TRANSPARENT,PorterDuff.Mode.CLEAR);
        invalidate();
    }


        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh)
        {
            super.onSizeChanged(0, 0, oldw, oldh);
            canvasPixelBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            drawPixelCanvas = new Canvas(canvasPixelBitmap);
        }

        @Override
        protected void onDraw(Canvas canvas)
        {
            canvas.drawBitmap(canvasPixelBitmap, 0, 0, pixelCanvasPaint);
            canvas.drawPath(path, drawPixel);


                int width = getMeasuredWidth();
                int height = getMeasuredHeight();
                // Vertical lines
                for (int i = 1; i < 16; i++) {
                    canvas.drawLine(width * i / 16, 0, width * i / 16, height, gridLines);
                }

                // Horizontal lines
                for (int i = 1; i < 16; i++) {
                    canvas.drawLine(0, height * i / 16, width, height * i / 16, gridLines);
                }
            }

    public ourPath getPath()
    {
        return path;
    }

    public static Paint getBrush() {return drawPixel; }


}
