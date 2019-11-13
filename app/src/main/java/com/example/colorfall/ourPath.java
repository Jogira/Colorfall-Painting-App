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
    private List<List> container = new LinkedList<>();
    private List<Action> actions = new LinkedList<>();//list where all user actions are stored
    private List<ourPaint> brushes = new LinkedList<>();//list of brushes which contains color, size etc.
    private ListIterator<ourPaint> iterBrush;
    private boolean isAuto = false;
    private drawView drawingView;


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


    public void save(String fileName) {
        Log.d("TAG", "starting ourPath save");//testing

        createContainerList();

        Log.d("TAG", "Brushes LL size = " + brushes.size());//testing
        Log.d("TAG", "Actions LL size = " + actions.size());//testing
        Log.d("TAG", "container size = " + container.size());//testing


        try {
            ObjectOutputStream saving = new ObjectOutputStream(new FileOutputStream(fileName));
            Log.d("TAG", "file made");//testing
            saving.writeObject(container);
            Log.d("TAG", "write complete");//testing
            saving.close();
        } catch (IOException sv) {
            Log.d("TAG", "Save exception is caught");
        }
    }

    public void load(String fileName) {
        Log.d("TAG", "starting ourPath load");//testing
        try {
            ObjectInputStream loading = new ObjectInputStream(new FileInputStream(fileName));
            Log.d("TAG", "file opened ");//testing
            Object loadedList = loading.readObject();//THIS IS CURRENTLY CAUSING ERROR
            Log.d("TAG", "read complete");//testing
            List<List> tmpLL = (LinkedList<List>)loadedList;
            loading.close();
            Log.d("TAG", "LL saved locally; file closed");//testing
            Log.d("TAG", "LL size = " + tmpLL.size());//testing
            unpack(tmpLL);
        } catch (FileNotFoundException f) {
            Log.d("TAG", "Load FileNotFound Exception is caught");
        }catch (IOException i) {
            Log.d("TAG", "Load IOException Exception is caught");
        }catch (ClassNotFoundException c) {
            Log.d("TAG", "Load ClassNotFound Exception is caught");
        }
    }


    /******************reading obj/ re-drawing stored paths on load********************************/
    public void unpack(List<List> tmpLL) {
        Log.d("TAG","defaultReadObject passed");//testing

        //testing if the ll we load is empty:
        if(tmpLL.isEmpty()){
            Log.d("TAG", "tmpLL is empty for some reason");//testing
        }
        //end testing
        brushes = tmpLL.get(0);
        actions = tmpLL.get(1);

        Log.d("TAG", "Brushes LL size = " + brushes.size());//testing
        Log.d("TAG", "Actions LL size = " + actions.size());//testing
        Log.d("TAG", "container size = " + container.size());//testing

        redraw();

    }//end readObject

    public void redraw(){
        isAuto = true;
        //Iterates throughout local LL to redraw image
        iterBrush = brushes.listIterator();
        ListIterator<Action> iterLine = actions.listIterator();

        int count = 1; //FOR DEBUG


        while(iterLine.hasNext()==true){           //We still want to look depend on the larger line-data LL when redrawing
            //is iterLine.next a moveTo?
            //Action redrawLine = iterLine.next();

            //if action.next is a move to: (or put in where moveTo executes and pop from front of brush list)
            if(0==1)
                drawView.setBrush(iterBrush.next());


            iterLine.next().perform(this);
            Log.d("TAG","looped " + count); //FOR DEBUG
            count ++;
        }
        isAuto = false;
    }

    private interface Action extends Serializable {
        void perform(Path path);
    }//end Action
    /*************End redrawing stored paths on load**********************************************/


    public List createContainerList() {
        container.add(brushes);
        container.add(actions);
        return container;
    }

    /****************Overrides****************************/
    @Override
    public void moveTo(float x, float y) {
        if(!(isAuto)) {//if we are not autodrawing
            brushes.add(drawView.getBrush());
            actions.add(new Move(x, y));
        } else {//if we are autodrawing
            drawView.setBrush(iterBrush.next());
        }

        super.moveTo(x, y);
        Log.d("TAG","in move drawing method. x=" + x + " y=" +y + " SIZE = " +  + actions.size());
    }

    @Override
    public void lineTo(float x, float y) {
        if(!(isAuto)) {//if we are not auto drawing
            actions.add(new Line(x, y));
        } else {

        }

        super.lineTo(x, y);
        Log.d("TAG","in line drawing method. x=" + x + " y=" +y + " SIZE = " +  + actions.size());
    }
    /*****************end overrides**********************/

    //Getter for linked list
    public List<Action> getLL()  {
        return actions;
    }

    public void getDrawingView() {
        drawingView = drawActivity.getDrawingView();
        //drawingView.onTouchEvent(MotionEvent.obtain());//once fill out obtain this would pass a valid event
    }

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
