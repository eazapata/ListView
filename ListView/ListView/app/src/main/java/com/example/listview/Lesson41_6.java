package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Lesson41_6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson41_6);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(),
                message,
                Toast.LENGTH_SHORT).show();
    }

    public void showFoodOrder(String message){ displayToast(message);
        Intent intent = new Intent(this,OrderActivity.class); startActivity(intent);
    }


    public void showDonutOrder(View view) {
        showFoodOrder(getString(R.string.donut_order_message));
    }


    public void showIceCreamOrder(View view) {
        showFoodOrder(getString(R.string.ice_cream_order_message));
    }


    public void showFroyoOrder(View view) {
        showFoodOrder(getString(R.string.froyo_order_message));
    }
}