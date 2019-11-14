package com.richc.timetables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timeTableSeekBar = findViewById(R.id.timeTableSeekBar);
        ListView timeTableListView = findViewById(R.id.timeTableListView);

        timeTableSeekBar.setMax(20);
        timeTableSeekBar.setProgress(10);

        timeTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                int min = 1;

                if (i < min) {
                    // Not allow zero as minimum
                    timeTableSeekBar.setProgress(min);
                } else {

                }

                Log.i("SeekBar value", Integer.toString(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
