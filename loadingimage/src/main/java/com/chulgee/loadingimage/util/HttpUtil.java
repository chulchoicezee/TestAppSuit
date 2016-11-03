package com.chulgee.loadingimage.util;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by chulchoice on 2016-10-14.
 */
public class HttpUtil {

    private static final String TAG = "HttpUtil";

    public static byte[] getDataFromUrl(String _url){
        byte[] response = {};

        try {
            URL url = new URL(_url);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setDoInput(true);
            int responseCode = conn.getResponseCode();
            Log.v(TAG, "responseCode = " + responseCode);
            InputStream in;
            if(responseCode >= HttpURLConnection.HTTP_BAD_REQUEST){
                in = conn.getErrorStream();
            }else{
                in= new BufferedInputStream(conn.getInputStream());
            }
            byte[] buf = new byte[1024];
            int count = 0;
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            while((count=in.read(buf)) != -1){
                bao.write(buf,0, count);
            }
            response = bao.toByteArray();
            bao.close();
            in.close();
            Log.v(TAG, "response = "+response);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

}
