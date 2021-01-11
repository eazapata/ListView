package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listView;
    private String [] activities = {"Lesson7","Task 41 (1-5)","Task 41 (6)"};
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,activities);
        listView.setAdapter(arrayAdapter);
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
        }
    }
}