package com.chulgee.loadingimage;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);

        testFile();
    }

    public void testFile(){
        /*FileCache fc = new FileCache(getApplication().getApplicationContext());
        File file = new File("chulgee.png");
        fc.saveFile(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.cat), file);
        assertEquals(true, file.exists());*/
    }
}