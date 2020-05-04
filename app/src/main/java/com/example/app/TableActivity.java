package com.example.app;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class TableActivity extends AppCompatActivity {
    ListView tableListView;

    public void createTable(int tableNumber){
        ArrayList<String> numberTable = new ArrayList<String>();
        for (int j = 1 ; j <= 20; j++ ){
            numberTable.add(Integer.toString(j * tableNumber));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, numberTable);
        tableListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        tableListView = findViewById(R.id.tableListView);
        SeekBar seekBar = findViewById(R.id.seekBar2);
        int max = 50;
        int sp = 1;
        seekBar.setMax(max);
        seekBar.setProgress(sp);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min =1;
                int tableNumber;
                if (progress < min){
                    seekBar.setProgress(min);
                    tableNumber = min;
                } else {
                    tableNumber = progress;
                }
                createTable(tableNumber);
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