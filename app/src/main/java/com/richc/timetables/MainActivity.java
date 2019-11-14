package com.richc.timetables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timesTableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timesTableSeekBar = findViewById(R.id.timeTableSeekBar);
        timesTableListView = findViewById(R.id.timeTableListView);

        timesTableSeekBar.setMax(20);
        timesTableSeekBar.setProgress(10);
        generateTimesTable(10); // init timesTable content with initial position

        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                int min = 1;
                int timesTableValue=1;

                if (i < min) {
                    // Not allow zero as minimum
                    timesTableSeekBar.setProgress(min);
                    timesTableValue = min;
                } else {
                    timesTableValue = i;
                }

                generateTimesTable(timesTableValue);
                Log.i("SeekBar value", Integer.toString(timesTableValue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void generateTimesTable (int timesTable) {
        ArrayList<String> timesTableContent = new ArrayList<>();

        for (int i=1;i<=10;i++) {
            timesTableContent.add(Integer.toString(i*timesTable));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);

        timesTableListView.setAdapter(arrayAdapter);
    }
}
