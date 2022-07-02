package com.example.progressbardemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ProgressBar pb;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runPb();
    }

    public void runPb()
    {
        pb = (ProgressBar)findViewById(R.id.pb);

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                count++;
                pb.setProgress(count);

                if(count == 100)
                    timer.cancel();
            }
        };

        timer.schedule(timerTask,0,100);
    }
}