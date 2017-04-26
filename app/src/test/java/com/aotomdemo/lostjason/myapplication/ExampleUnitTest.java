package com.aotomdemo.lostjason.myapplication;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.BidiFormatter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Test
    public void addition_isCorrect() throws Exception {
        BidiFormatter bidiFormatter =BidiFormatter.getInstance();
        bidiFormatter.getStereoReset();
    }
}