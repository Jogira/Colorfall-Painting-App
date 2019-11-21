package com.example.colorfall;

import android.content.Context;
import android.graphics.Path;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import android.graphics.Paint;
import android.view.MotionEvent;

//WORK IN PROGRESS//
public class ourPath extends Path implements Serializable {

    private static final long serialVersionUID = -5974912367682897467L;//used for serializing

    //private drawView drawingView;
    private List<Action> actions = new LinkedList<>();//list where all user actions are stored
    private List<ourPaint> brushes = new LinkedList<>();//list of brushes which contains color, size etc.



    /***********************************Testing methods***************************/
    public void printList() {
        int i = 1;
        for (Action action : actions) {
            System.out.println(action);
            System.out.println(i);
            i++;
        }
    }
    /*******************************end Testing methods***************************/

    private interface Action extends Serializable {
        void perform(Path path);
    }//end Action
    /*************End redrawing stored paths on load**********************************************/


    /****************Overrides****************************/
    @Override
    public void moveTo(float x, float y) {
        brushes.add(drawView.getBrush());
        actions.add(new Move(x, y));

        super.moveTo(x, y);
        Log.d("TAG","in move drawing method. x=" + x + " y=" +y + " SIZE = " +  + actions.size());
    }

    @Override
    public void lineTo(float x, float y) {
        actions.add(new Line(x, y));


        super.lineTo(x, y);
        Log.d("TAG","in line drawing method. x=" + x + " y=" +y + " SIZE = " +  + actions.size());
    }
    /*****************end overrides**********************/


    /**************inner MOVE class*******************/
    private static final class Move implements Action, Serializable {

        private final float x, y;

        public Move(float x, float y) {
            this.x = x;
            this.y = y;
            Log.d("TAG","in move constructor. x=" + x + " y=" +y);
        }

        @Override
        public void perform(Path path) {
            path.moveTo(x, y);
        }
    }
    /***********End inner MOVE class*******************/


    /**************inner LINE class*******************/
    private static final class Line implements Action, Serializable {

        private final float x, y;

        public Line(float x, float y) {
            this.x = x;
            this.y = y;
            Log.d("TAG","in line constructor. x=" + x + " y=" +y);
        }

        @Override
        public void perform(Path path) {
            path.lineTo(x, y);
        }
    }
    /***********End inner LINE class*******************/

}
