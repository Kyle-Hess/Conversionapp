package com.example.kyle.conversionapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SettingsActivity extends AppCompatActivity {
    private RadioGroup radioButtonGroup;
    private Button confirm;
    SharedPreferences prefs;
    String unitName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher_two);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_settings);
        prefs = getSharedPreferences("prefs", MODE_PRIVATE);

        confirm = (Button) findViewById(R.id.buttonConfirm);
        radioButtonGroup = (RadioGroup) findViewById(R.id.unit_group);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                prefs.edit().putString("prefRadio", unitName).apply();
                System.out.println(unitName);
                startActivity(intent);
            }
        });

        radioButtonGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                updateUnitType();
            }
        });
    }

    //gets the name of the selected radio Button and saves it the Shared prefs.
    private void updateUnitType() {
        int radioButtonID = radioButtonGroup.getCheckedRadioButtonId();
        View radioButtonG = radioButtonGroup.findViewById(radioButtonID);
        RadioButton r = (RadioButton) radioButtonG;
        unitName = r.getText().toString();
        prefs.edit().putString("prefRadio", unitName).apply();
        System.out.println(unitName);
    }

    //when the app starts up again, the unit name is retrieved and radio button set from the users last unit choice
    @Override
    protected void onStart() {
        super.onStart();
        try {
            unitName = prefs.getString("prefRadio", unitName);

            switch (unitName) {
                case "Length":
                    radioButtonGroup.check(R.id.radioLength);
                    break;
                case "Speed":
                    radioButtonGroup.check(R.id.radioSpeed);
                    break;
                case "Temperature":
                    radioButtonGroup.check(R.id.radioTemperature);
                    break;
                case "Mass":
                    radioButtonGroup.check(R.id.radioMass);
                    break;
            }
        } catch (Exception e) {
            radioButtonGroup.check(R.id.radioLength);
        }
    }

    //when the app is closed, the unit named is saved
    @Override
    protected void onStop() {
        super.onStop();
        prefs.edit().putString("prefRadio", unitName).apply();
    }
}
