package com.example.listview;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity implements RadioButton.OnClickListener {
    private static final String TAG_ACTIVITY = OrderActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        RadioButton sameDay = (RadioButton) findViewById(R.id.sameday);
        RadioButton nextDay = (RadioButton) findViewById(R.id.nextday);
        RadioButton pickUp = (RadioButton) findViewById(R.id.pickup);
        sameDay.setOnClickListener(this);
        nextDay.setOnClickListener(this);
        pickUp.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        boolean checked = ((RadioButton) v).isChecked();

        switch (v.getId()) {
            case R.id.sameday:
                if(checked)// Same day service
                    Toast.makeText(this,getString(R.string.chosen) + getString(R.string.same_day),Toast.LENGTH_SHORT).show();
                break;
            case R.id.nextday:
                if (checked)// Next day delivery
                    Toast.makeText(this,getString(R.string.chosen) + getString(R.string.next_day),Toast.LENGTH_SHORT).show();
                break;
            case R.id.pickup:
                if(checked)// Pick up
                    Toast.makeText(this,getString(R.string.chosen) + getString(R.string.pick_up),Toast.LENGTH_SHORT).show();
                break;
            default:
                Log.d(TAG_ACTIVITY, getString(R.string.nothing_clicked));
                break;
        }
    }
}