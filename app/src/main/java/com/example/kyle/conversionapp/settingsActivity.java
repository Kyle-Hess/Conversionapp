package com.example.kyle.conversionapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.prefs.Preferences;

public class SettingsActivity extends AppCompatActivity {

    private RadioButton radioLength;
    private RadioButton radioSpeed;
    private Button confirm;

    SharedPreferences prefs;
    String unitName;
    private RadioGroup radioButtonGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        prefs = getSharedPreferences("prefs", MODE_PRIVATE);

        radioLength = (RadioButton) findViewById(R.id.radioLength);
        radioSpeed = (RadioButton) findViewById(R.id.radioSpeed);
        confirm = (Button) findViewById(R.id.buttonConfirm);

        radioButtonGroup = (RadioGroup) findViewById(R.id.unit_group);


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);

                //prefs.edit().putString("prefs",unitName).apply();

                intent.putExtra("unit", unitName);
                System.out.println(unitName);
                startActivity(intent);
            }
        });

        radioLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApplyButton();
                //unitName = "Length";
            }
        });

        radioSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApplyButton();
                //unitName = "Speed";
            }
        });
    }

    private void ApplyButton() {
        int radioButtonID = radioButtonGroup.getCheckedRadioButtonId();
        View radioButtonG = radioButtonGroup.findViewById(radioButtonID);
        int index = radioButtonGroup.indexOfChild(radioButtonG);
        System.out.println(index);

        RadioButton r = (RadioButton) radioButtonGroup.getChildAt(index);
        unitName = r.getText().toString();
        System.out.println(unitName);

    }


    @Override
    protected void onStart() {
        super.onStart();
        try {

            unitName = prefs.getString("prefs", unitName);

//            switch (unitName){
//                case "Length":
//                    unitName = prefs.getString("unit", String.valueOf(radioLength));
//                case "Speed":
//                    unitName = prefs.getString("unit", String.valueOf(radioSpeed));
//            }
            //unitName = String.valueOf(radioLength);

        } catch (Exception e) {
            unitName = "Length";
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        prefs.edit().putString("prefs", unitName).apply();
    }

}
