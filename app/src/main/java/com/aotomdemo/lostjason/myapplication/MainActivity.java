package com.aotomdemo.lostjason.myapplication;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.aotomdemo.lostjason.myapplication.log.Logshow;
import com.aotomdemo.lostjason.myapplication.sample.M_TEST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity    {
ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m_main);
      //  viewPager = (ViewPager) findViewById(R.id.viewpager);
        List<String>  sd =new ArrayList<>();
        sd.add("s1");
        sd.add("s2");
        sd.add("s3");
        sd.add("s4");
        sd.add("s5");
     //   viewPager.setAdapter(new MypagerAdapter(sd));
        TextView  te = (TextView) findViewById(R.id.tv);
               te.setOnGenericMotionListener(new View.OnGenericMotionListener() {
                   @Override
                   public boolean onGenericMotion(View v, MotionEvent event) {
                       Logshow.logshow("==============");
                       return false;
                   }
               });



    }
    class MypagerAdapter extends PagerAdapter{
        List<String> list;
        public MypagerAdapter(List<String> list) {
            this.list=list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
           return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            return super.instantiateItem(container, position);
        }

        @Override
        public int getItemPosition(Object object) {

            return super.getItemPosition(object);
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
         //   ((ViewPager)container).removeView();
        }
    }
         public M_TEST  getmtest(){
             return new M_TEST();
         }

}
