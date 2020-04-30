package com.example.app;

import  androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.app.R.id.btn1;
import static com.example.app.R.id.list_item;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        ArrayList<String> myFriends = new ArrayList<String>();
        myFriends.add("1");
        myFriends.add("2");
        myFriends.add("3");
        myFriends.add("4");
        myFriends.add("5");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myFriends);

        listView.setAdapter(arrayAdapter);

    }
}
