package com.hastiya.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class stopwatch extends AppCompatActivity {
    Button sta,btnstop;
    ImageView arow;
    Animation rounding;
    Chronometer timehere;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        sta = findViewById(R.id.sta);
        arow = findViewById(R.id.arow);
        btnstop = findViewById(R.id.btnstop);
        timehere = findViewById(R.id.timehere);


        btnstop.setAlpha(0);

        rounding = AnimationUtils.loadAnimation(this, R.anim.rounding);
        sta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arow.startAnimation(rounding);
                btnstop.animate().alpha(1).translationY(-80).setDuration(300).start();
                sta.animate().alpha(1).setDuration(300).start();

                timehere.setBase(SystemClock.elapsedRealtime());
                timehere.start();
            }
        });
    }
}