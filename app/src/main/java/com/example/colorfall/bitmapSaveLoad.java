package com.example.colorfall;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class bitmapSaveLoad {

    static public Bitmap loadBitmap(String fileName) {
        Log.d("TAG", "line before decoded bitmap returned");
        return BitmapFactory.decodeFile(fileName); // bitmap is the Bitmap instance

//        try (
//                //FileInputStream in = new FileInputStream(fileName)) {
//
//
//
//            // PNG is a lossless format, the compression factor (100) is ignored
//        } catch (
//                IOException e) {
//            e.printStackTrace();
//        }
    }

    static public void saveBitmap(String fileName, Bitmap bitmap) {
        try (
                FileOutputStream out = new FileOutputStream(fileName)) {
                Log.d("TAG", "output file created");
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, out); // bitmap is the Bitmap instance
            // PNG is a lossless format, the compression factor (100) is ignored
                Log.d("TAG", "bitmap compressed");

                out.flush();
                out.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}