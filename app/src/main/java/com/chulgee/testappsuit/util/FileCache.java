package com.chulgee.testappsuit.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by chulchoice on 2016-10-07.
 */
public class FileCache {
    private static final String TAG = "FileCache";
    private File cacheDir;

    public FileCache(Context context){
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
            cacheDir = context.getExternalCacheDir();
        else
            cacheDir = context.getCacheDir();
        if(!cacheDir.exists())
            cacheDir.mkdir();
    }

    public File getFile(String url){
        String filename = null;
        filename = String.valueOf(url.hashCode());
        File f = new File(cacheDir, filename);
        return f;
    }

    public void saveFile(Bitmap bmp, File file){
        OutputStream out = null;

        try {
            file.createNewFile();
            out = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void clear(){
        File[] files = cacheDir.listFiles();
        Log.v(TAG, "files="+files);
        if(files == null)
            return;
        for(File f : files) {
            Log.v(TAG, "f="+f.getAbsolutePath());
            f.delete();
        }
    }
}
