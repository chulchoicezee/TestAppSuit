package com.chulgee.loadingimage.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.chulgee.loadingimage.R;

import java.io.File;
import java.io.FileInputStream;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        ImageView iv = (ImageView)findViewById(R.id.sub_iv1);
        Intent i = getIntent();
        String filepath = i.getStringExtra("filepath");
        if(filepath!=null){
            File f = new File(filepath);
            Bitmap bmp = decodeFile(f);
            if (iv != null) {
                iv.setImageBitmap(bmp);
            }
        }
    }

    private Bitmap decodeFile(File f){
        Bitmap bmp = null;
        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inJustDecodeBounds = true;
        FileInputStream stream = null;
        //stream = new FileInputStream(f);
        bmp = BitmapFactory.decodeFile(f.getAbsolutePath());
        //stream.close();
        return bmp;
    }
}
