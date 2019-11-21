package com.example.colorfall;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class bitmapSaveLoad {

    static public Bitmap loadBitmap(String fileName) {
        Log.d("TAG", "line before decoded bitmap returned");
        Bitmap loadedBitmap = BitmapFactory.decodeFile(fileName); // bitmap is the Bitmap instance

        loadedBitmap = loadedBitmap.copy(Bitmap.Config.ARGB_8888, true);

        return loadedBitmap;
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






//    public static Bitmap decodeMutableBitmapFromResourceId(final Context context, final int bitmapResId) {
//        final BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
//            bitmapOptions.inMutable = true;
//        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), bitmapResId, bitmapOptions);
//        if (!bitmap.isMutable())
//            bitmap = convertToMutable(context, bitmap);
//        return bitmap;
//    }
//
//    public static Bitmap convertToMutable(final Context context, final Bitmap imgIn) {
//
//        final BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
//        bitmapOptions.inMutable = true;
//
//        final int width = imgIn.getWidth(), height = imgIn.getHeight();
//        final Bitmap.Config type = imgIn.getConfig();
//        File outputFile = null;
//        final File outputDir = context.getCacheDir();
//        try {
//            outputFile = File.createTempFile(Long.toString(System.currentTimeMillis()), null, outputDir);
//            outputFile.deleteOnExit();
//            final RandomAccessFile randomAccessFile = new RandomAccessFile(outputFile, "rw");
//            final FileChannel channel = randomAccessFile.getChannel();
//            final MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, imgIn.getRowBytes() * height);
//            imgIn.copyPixelsToBuffer(map);
//            imgIn.recycle();
//            final Bitmap result = Bitmap.createBitmap(width, height, type);
//            map.position(0);
//            result.copyPixelsFromBuffer(map);
//            channel.close();
//            randomAccessFile.close();
//            outputFile.delete();
//            return result;
//        } catch (final Exception e) {
//        } finally {
//            if (outputFile != null)
//                outputFile.delete();
//        }
//        return null;
//    }
}