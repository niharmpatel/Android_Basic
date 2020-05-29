package com.example.app;

import  androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = findViewById(R.id.listView);
        final ArrayList<String> myFriends = new ArrayList<String>();
        myFriends.add("Table");
        myFriends.add("TImer");
        myFriends.add("Brain Trainer");

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myFriends);

        listView.setAdapter(arrayAdapter);
        arrayAdapter.getPosition("1");


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position  , long id) {
                if (position  == 0) {
                    startActivity(new Intent(MainActivity.this, TableActivity.class));
                } else if (position == 1){
                    startActivity(new Intent(MainActivity.this, Timer.class));
                }else if (position == 2){
                    startActivity(new Intent(MainActivity.this, BrainTrainer.class));
                }


            }
        });




    }
}
