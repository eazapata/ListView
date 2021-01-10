package com.example.listview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Lesson41_1_5 extends AppCompatActivity implements TextView.OnEditorActionListener, AdapterView.OnItemSelectedListener{

    EditText phoneEdit;
    private static final int PERMISSION_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson41_1_5);

        phoneEdit = (EditText) findViewById(R.id.phoneText);
        phoneEdit.setOnEditorActionListener(this);
        Spinner spinner = (Spinner) findViewById(R.id.spinnerPhone);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.phone_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
    public void showMessage(View v) {
        EditText editText = (EditText) findViewById(R.id.capitalize);
        Toast.makeText(this, editText.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (v.getId() == phoneEdit.getId()) {
            makeCall();
            return false;
        }
        return false;
    }
    public void makeCall() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phoneEdit.getText()));
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            startActivity(intent);
        } else {
            requestPermission();
        }
    }
    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(Lesson41_1_5.this, Manifest.permission.CALL_PHONE)) {
        } else {
            ActivityCompat.requestPermissions(Lesson41_1_5.this, new String[]{Manifest.permission.CALL_PHONE}, PERMISSION_REQUEST_CODE);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    makeCall();
                }
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if (position == 0) {
            Toast.makeText(this, phoneEdit.getText() + " " + "Home", Toast.LENGTH_SHORT).show();
        } else if (position == 1) {
            Toast.makeText(this, phoneEdit.getText() + " " + "Work", Toast.LENGTH_SHORT).show();
        } else if (position == 2) {
            Toast.makeText(this, phoneEdit.getText() + " " + "Mobile", Toast.LENGTH_SHORT).show();
        } else if (position == 3) {
            Toast.makeText(this, phoneEdit.getText() + " " + "Other", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void createDialog(View v) {
        final TextView alertResponse = (TextView) findViewById(R.id.alertResponse);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert");
        builder.setMessage("Click Ok to continue or Cancel to stop");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertResponse.setText("You clicked Ok");
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertResponse.setText("You clicked Cancel");
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new timeFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");;
    }
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new dateFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}