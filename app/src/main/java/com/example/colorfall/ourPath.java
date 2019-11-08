package com.example.colorfall;

import android.content.Context;
import android.graphics.Path;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import android.graphics.Paint;

//WORK IN PROGRESS//
public class ourPath extends Path implements Serializable {

    private static final long serialVersionUID = -5974912367682897467L;//used for serializing

    //private drawView drawingView;
    private List<List> container = new LinkedList<>();
    private List<Action> actions = new LinkedList<>();//list where all user actions are stored
    private List<Paint> brushes = new LinkedList<>();//list of brushes which contains color, size etc.


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
        Log.d("TAG", "LL size = " + actions.size());//testing
        try {
            ObjectOutputStream saving = new ObjectOutputStream(new FileOutputStream(fileName));
            Log.d("TAG", "file made");//testing
            saving.writeObject(actions);
            Log.d("TAG", "write complete");//testing
            saving.close();
        } catch (IOException sv) {
            Log.d("TAG", "Save exception is caught");
        }
    }

    public void load(String fileName) {
        Log.d("TAG", "starting ourPath save");//testing
        try {
            ObjectInputStream loading = new ObjectInputStream(new FileInputStream(fileName));
            Log.d("TAG", "file opened ");//testing
            Object loadedList = loading.readObject();
            Log.d("TAG", "read complete");//testing
            List<Action> tmpLL = (LinkedList<Action>)loadedList;
            loading.close();
            Log.d("TAG", "LL saved locally; file closed");//testing
            Log.d("TAG", "LL size = " + tmpLL.size());//testing
            redraw(tmpLL);
        } catch (Exception ld) {
            Log.d("TAG", "Load Exception is caught");
        }
    }


    /******************reading obj/ re-drawing stored paths on load********************************/
    public void redraw(List<Action> tmpLL) {
        Log.d("TAG","defaultReadObject passed");//testing

        //Iterates throught local LL to redraw image
        ListIterator<Action> iter = tmpLL.listIterator(0);
        int count = 1;

        while(iter.hasNext()==true){
            //is iter.next a str?
            //yes: set brush color
            //no: do below actions (except cannot call iter.next again so hmm

            iter.next().perform(this);
            Log.d("TAG","looped " + count);
            count ++;
        }

        actions = tmpLL;
        Log.d("TAG", "'actions' size = " + actions.size());//testing

    }//end readObject

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
        brushes.add(drawView.getBrush());

        actions.add(new Move(x, y));
        super.moveTo(x, y);
        Log.d("TAG","move 1. x=" + x + " y=" +y + " SIZE = " +  + actions.size());
    }

    @Override
    public void lineTo(float x, float y) {
        actions.add(new Line(x, y));
        super.lineTo(x, y);
        Log.d("TAG","line 1. x=" + x + " y=" +y + " SIZE = " +  + actions.size());
    }
    /*****************end overrides**********************/

    //Getter for linked list
    public List<Action> getLL()  {
        return actions;
    }

    /**************inner MOVE class*******************/
    private static final class Move implements Action, Serializable {

        private final float x, y;

        public Move(float x, float y) {
            this.x = x;
            this.y = y;
            Log.d("TAG","it moved. x=" + x + " y=" +y);
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
            Log.d("TAG","it lined. x=" + x + " y=" +y);
        }

        @Override
        public void perform(Path path) {
            path.lineTo(x, y);
        }
    }
    /***********End inner LINE class*******************/

}
