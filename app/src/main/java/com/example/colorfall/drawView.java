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

public class drawView extends View
{
    LayoutParams params;
    private Path path = new Path();
    private Paint brush = new Paint();


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

    @Override
    protected void onDraw(Canvas canvas)
    {
        canvas.drawPath(path, brush);
    }
}