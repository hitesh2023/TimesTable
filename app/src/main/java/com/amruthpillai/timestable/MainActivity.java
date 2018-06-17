package com.amruthpillai.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timesTableListView;

    public void generateTimesTable(int timesTable) {
        ArrayList<String> timesTableContents = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            timesTableContents.add(Integer.toString(i * timesTable));
        }

        ArrayAdapter<String> timesTableArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContents);
        timesTableListView.setAdapter(timesTableArrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar timesTableSeekBar = (SeekBar) findViewById(R.id.timesTableSeekBar);
        timesTableListView = (ListView) findViewById(R.id.timesTableListView);

        int maximumTimesTable = 20;
        int initialTimesTable = 10;

        timesTableSeekBar.setMax(maximumTimesTable);
        timesTableSeekBar.setProgress(initialTimesTable);

        generateTimesTable(initialTimesTable);

        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int timesTable;

                if (i < min) {
                    timesTable = 1;
                } else {
                    timesTable = i;
                }

                generateTimesTable(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        int timesTable = 10;


    }
}
