package com.example.todolistsound29032022.utils;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
    public static String saveToInternalStorage(Bitmap bitmapImage, Context context, String nameFile) {
        ContextWrapper cw = new ContextWrapper(context);
        // path to /data/data/yourapp/app_data/assets/images
        File directory = cw.getDir("assets/images", Context.MODE_PRIVATE);
        // Create assets
        File myPath = new File(directory, nameFile + ".png");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(myPath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return directory.getAbsolutePath();
    }

    public static Bitmap loadImageFromStorage(String path) {
        try {
            File file = new File(path);
            Bitmap bitmap = BitmapFactory.decodeStream(new FileInputStream(file));
            return bitmap;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
