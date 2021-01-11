package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Lesson7 extends AppCompatActivity {
    private TextView textView;
    private TextView timeText;
    private ImageButton imgButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson7);

        textView = (TextView) findViewById(R.id.redText);
        imgButton = (ImageButton) findViewById(R.id.imgButton);
        //  imgButton.playSoundEffect(SoundEffectConstants.CLICK);
    }

    public void changeTextColor(View v) {
        Button changeButton = (Button) findViewById(R.id.timeButton);
        TextView timeText = (TextView) findViewById(R.id.timeText);
        changeButton.setVisibility(v.GONE);
        timeText.setVisibility(v.VISIBLE);
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        SimpleDateFormat hourFormat = new SimpleDateFormat("hh:mm");
        String strDate = dateFormat.format(date);
        String strHour = hourFormat.format(date);
        timeText.setText(strDate + " " + strHour);
        textView.setTextColor(Color.argb(255, 255, 0, 0));
    }

    public void copyText(View v) {
        EditText initial = (EditText) findViewById(R.id.initialText);
        EditText copy = (EditText) findViewById(R.id.copiedText);
        copy.setText(initial.getText());
    }

    public void setCheckBoxText(View v) {
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox);
        if (checkBox.isChecked()) {
            checkBox.setText("This checkbox is: checked");
        } else {
            checkBox.setText("This checkbox is: unchecked");
        }
    }

    public void setColour(View v) {
        RadioButton blue = (RadioButton) findViewById(R.id.blue);
        RadioButton red = (RadioButton) findViewById(R.id.red);
        RadioButton green = (RadioButton) findViewById(R.id.green);
        TextView colorText = (TextView) findViewById(R.id.pickAColour);
        if(v.getId() == blue.getId()){
            colorText.setBackgroundColor(getResources().getColor(R.color.blue));

        }else if (v.getId() == red.getId()){
            colorText.setBackgroundColor(getResources().getColor(R.color.red));

        }else if (v.getId() == green.getId()){
            colorText.setBackgroundColor(getResources().getColor(R.color.green));

        }

    }
}