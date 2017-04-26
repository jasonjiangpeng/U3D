package com.aotome202.lostjason.e202project.apputils;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

/**
 * Created by LostJason on 2017/4/6.
 */

public class Logshow {
    private  static boolean is_dug=true;
    private  static String TAGE="message======:";
    public  static  void  logShow(String message){
        if (is_dug){
            Log.v(TAGE,message);
        }

    }
    public  static  void  nextActivity(Activity message,Class nextclass){
        Intent intent=new Intent(message,nextclass);
        message.startActivity(intent);
        message.finish();

    }

}
