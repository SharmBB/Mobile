package com.example.aniation;



import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    //add images from drawable to array
    int images[] = {R.drawable.room1, R.drawable.room2, R.drawable.room54,R.drawable.r4,R.drawable.b1,R.drawable.b3};

    int currentPageCunter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find view by id
        viewPager = findViewById(R.id.viewpager);
        //add adapter
        viewPager.setAdapter(new SideAdapter(images, MainActivity.this));

        //auto change image
        final Handler handler = new Handler();
        final Runnable update  = new Runnable() {
            @Override
            public void run() {
                if (currentPageCunter == images.length){
                    currentPageCunter = 0 ;

                }

                viewPager.setCurrentItem(currentPageCunter++,true);
            }
        };

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        },2500,2500);

    }
}
