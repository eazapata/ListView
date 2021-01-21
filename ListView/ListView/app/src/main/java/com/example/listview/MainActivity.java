package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listView;
    private Adapter adapter;
    private ArrayList<Item> activities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        this.getActivities();
        this.adapter = new Adapter(this,activities);
        listView.setAdapter(this.adapter);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent;
        switch (position){
            case 0:
                intent = new Intent(this, Lesson7.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(this,Lesson41_1_5.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(this,Lesson41_6.class);
                startActivity(intent);
                break;
            default:
                Log.d("Switch fail","Activity not found.");
        }
    }

    private void getActivities(){
        this.activities = new ArrayList<>();
        this.activities.add(new Item("Lesson 7 "));
        this.activities.add(new Item("Task 41 (1-5)"));
        this.activities.add(new Item("Task 41 (6)"));
    }
}