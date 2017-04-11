package com.example.kyle.conversionapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView unitTitle;
    public String currentUnitType;
    private Spinner spinnerFrom;
    private Spinner spinnerTo;
    private EditText inputFrom;
    private EditText inputTo;
    private boolean repeatingText = true;
    private ArrayAdapter<CharSequence> adapterLength;
    private ArrayAdapter<CharSequence> adapterSpeed;
    private ArrayAdapter<CharSequence> adapterTemperature;
    private ArrayAdapter<CharSequence> adapterMass;

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher_two);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_main);

        unitTitle = (TextView) findViewById(R.id.unit_title);
        spinnerFrom = (Spinner) findViewById(R.id.spinner_from);
        spinnerTo = (Spinner) findViewById(R.id.spinner_to);

        adapterLength = ArrayAdapter.createFromResource(this, R.array.length_array, android.R.layout.simple_spinner_item);
        adapterSpeed = ArrayAdapter.createFromResource(this, R.array.speed_array, android.R.layout.simple_spinner_item);
        adapterTemperature = ArrayAdapter.createFromResource(this, R.array.temperature_array, android.R.layout.simple_spinner_item);
        adapterMass = ArrayAdapter.createFromResource(this, R.array.mass_array, android.R.layout.simple_spinner_item);

        spinnerFrom.setAdapter(adapterLength);
        spinnerTo.setAdapter(adapterLength);

        inputFrom = (EditText) findViewById(R.id.input_from);
        inputTo = (EditText) findViewById(R.id.input_to);

        prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        currentUnitType = prefs.getString("prefRadio", "");

        //changed spinner items to the selected unit name
        changeUnitAdapters();

        //Button to Unit selection (settings) screen
        Button unitButton = (Button) findViewById(R.id.button);
        unitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
        //clears the text input areas when selected
        View.OnFocusChangeListener f = new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    inputFrom.getText().clear();
                    inputTo.getText().clear();
                }
            }
        };
        inputFrom.setOnFocusChangeListener(f);
        inputTo.setOnFocusChangeListener(f);

        //// TODO: 11/04/2017 Add: when new unit from one of the spinners is selected the result in the output is updated
        spinnerFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String spinnerFromSelected = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String spinnerToSelected = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //// TODO: 23/03/2017 Try and simplify the on text change input listeners into one listener
        //Converts an inputted number based on the unit of measurement selected from the 'spinnerFrom' spinner & output the result in inputTo editText
        inputFrom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence string, int start, int before, int count) {
                try {
                    System.out.println("test from");
                    //onTextConvert1(value);
                    String spinnerUnitFrom = (String) spinnerFrom.getSelectedItem();
                    String spinnerUnitTo = (String) spinnerTo.getSelectedItem();
                    Double valueFrom = Double.valueOf(inputFrom.getText().toString());
                    double result = Converter.convert(currentUnitType, valueFrom, spinnerUnitFrom, spinnerUnitTo);
                    if (repeatingText) {
                        repeatingText = false;
                        inputTo.setText(String.valueOf(String.format("%.6f", result)));
                    } else {
                        repeatingText = true;
                    }
                } catch (Exception e) {

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //Converts an inputted number based on the unit of measurement selected from the 'spinnerTo' spinner & output the result in inputFrom editText
        inputTo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence string, int start, int before, int count) {
                try {
                    System.out.println("test to");
                    String spinnerUnitFrom = (String) spinnerFrom.getSelectedItem();
                    String spinnerUnitTo = (String) spinnerTo.getSelectedItem();
                    Double valueTo = Double.valueOf(inputTo.getText().toString());
                    double result = Converter.convert(currentUnitType, valueTo, spinnerUnitTo, spinnerUnitFrom);
                    System.out.println(result);
                    if (repeatingText) {
                        repeatingText = false;
                        inputFrom.setText(String.valueOf(String.format("%.6f", result)));
                    } else {
                        repeatingText = true;
                    }
                } catch (Exception e) {
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    //Simple method that changes the Unit type that the user selected from the Settings activity
    private void changeUnitAdapters() {
        try {
            switch (currentUnitType) {
                case "Length":
                    spinnerFrom.setAdapter(adapterLength);
                    spinnerTo.setAdapter(adapterLength);
                    unitTitle.setText(currentUnitType);
                    break;
                case "Speed":
                    spinnerFrom.setAdapter(adapterSpeed);
                    spinnerTo.setAdapter(adapterSpeed);
                    unitTitle.setText(currentUnitType);
                    break;
                case "Temperature":
                    spinnerFrom.setAdapter(adapterTemperature);
                    spinnerTo.setAdapter(adapterTemperature);
                    unitTitle.setText(currentUnitType);
                    break;
                case "Mass":
                    spinnerFrom.setAdapter(adapterMass);
                    spinnerTo.setAdapter(adapterMass);
                    unitTitle.setText(currentUnitType);
                    break;
            }
        } catch (Exception e) {

        }
    }
}


