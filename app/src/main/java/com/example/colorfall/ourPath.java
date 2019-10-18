package com.example.colorfall;

import android.graphics.Path;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


public class ourPath extends Path implements Serializable {

    private List<Action> actions = new LinkedList<>();

    @Override
    public void moveTo(float x, float y) {
        actions.add(new Move(x, y));
        super.moveTo(x, y);
    }

    @Override
    public void lineTo(float x, float y) {
        actions.add(new Line(x, y));
        super.lineTo(x, y);
    }

    private interface Action extends Serializable {
        void perform(Path path);
    }


    /**************inner MOVE class*******************/
    private static final class Move implements Action {

        private final float x, y;

        public Move(float x, float y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void perform(Path path) {
            path.moveTo(x, y);
        }
    }//end inner move class

    /**************inner LINE class*******************/
    private static final class Line implements Action {

        private final float x, y;

        public Line(float x, float y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void perform(Path path) {
            path.lineTo(x, y);
        }
    }//end LINE class



}
