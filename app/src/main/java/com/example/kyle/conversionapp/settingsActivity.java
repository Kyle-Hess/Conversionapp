package com.example.kyle.conversionapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import java.util.prefs.Preferences;

public class SettingsActivity extends AppCompatActivity {

    private RadioButton radioLength;
    private RadioButton radioSpeed;
    private Button confirm;

    SharedPreferences prefs;
    String unitName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        prefs = getSharedPreferences("Value", MODE_PRIVATE);

        radioLength = (RadioButton) findViewById(R.id.radioLength);
        radioSpeed = (RadioButton) findViewById(R.id.radioSpeed);
        confirm = (Button) findViewById(R.id.buttonConfirm);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                intent.putExtra("unit", unitName);
                startActivity(intent);
            }
        });

        radioLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unitName = "Length";
            }
        });

        radioSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unitName = "Speed";
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        try {
            //unitName = String.valueOf(radioLength);
            unitName = prefs.getString("unit", String.valueOf(radioLength));

        } catch (Exception e) {
            unitName = "Length";
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        prefs.edit().putString("unit",String.valueOf(radioLength)).apply();
    }

}
