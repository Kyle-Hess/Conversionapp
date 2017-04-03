package com.example.kyle.conversionapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView unitTitle;
    private Spinner spinnerFrom;
    private Spinner spinnerTo;
    private EditText inputFrom;
    private EditText inputTo;
    private ArrayAdapter<CharSequence> adapterLength;
    private ArrayAdapter<CharSequence> adapterSpeed;
    SharedPreferences prefs;

    public String currentUnitType ="Length";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        unitTitle = (TextView) findViewById(R.id.unit_title);
        spinnerFrom = (Spinner) findViewById(R.id.spinner_from);
        spinnerTo = (Spinner) findViewById(R.id.spinner_to);

        adapterLength = ArrayAdapter.createFromResource(this, R.array.length_array, android.R.layout.simple_spinner_item);
        adapterSpeed = ArrayAdapter.createFromResource(this, R.array.speed_array, android.R.layout.simple_spinner_item);

        spinnerFrom.setAdapter(adapterLength);
        spinnerTo.setAdapter(adapterLength);

        inputFrom = (EditText) findViewById(R.id.input_from);
        inputTo = (EditText) findViewById(R.id.input_to);
        //getStart();


//        prefs = PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());
//        currentUnitType = prefs.getString("prefs",currentUnitType);
//        unitTitle.setText(currentUnitType);



//// TODO: 19/03/2017 put into method
        Intent rIntent = getIntent();
        currentUnitType = rIntent.getStringExtra("unit");
        System.out.println(currentUnitType);
        unitTitle.setText(currentUnitType);
        System.out.println(unitTitle);

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
            }
        } catch (Exception e) {

        }

        //Button to Unit selection screen
        Button unitButton = (Button) findViewById(R.id.button);
        unitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

//        inputFrom.addTextChangedListener(tw);
//        inputTo.addTextChangedListener(tw);


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

        //// TODO: 23/03/2017 Try and simplify the on text change input listeners into one listener
        //// TODO: 23/03/2017 Try to add an if or switch to separate Length and speed conversions for cleaner layout

        //// TODO: 31/03/2017 Fix inputing decimal numbers

        Converter converter = new Converter();

        inputFrom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence string, int start, int before, int count) {
                //// TODO: 19/03/2017 Mabey try to simplify into a single method.

                try {
                    System.out.println("test from");
                    //onTextConvert1(value);
                    String spinnerUnitFrom = (String) spinnerFrom.getSelectedItem();
                    String spinnerUnitTo = (String) spinnerTo.getSelectedItem();
                    double value = Integer.parseInt(string.toString());
                    double result = Converter.convert(currentUnitType,value, spinnerUnitFrom, spinnerUnitTo);
                    System.out.println(result);
                    inputTo.setText(String.valueOf(result));

                } catch (Exception e) {

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        inputTo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence string, int start, int before, int count) {
                //onTextConvert2(string);

                try {
                    System.out.println("test to");
                    String spinnerUnitFrom = (String) spinnerFrom.getSelectedItem();
                    String spinnerUnitTo = (String) spinnerTo.getSelectedItem();
                    double value = Integer.parseInt(string.toString());
                    double result = Converter.convert(currentUnitType, value, spinnerUnitTo, spinnerUnitFrom);
                    System.out.println(result);
                    inputFrom.setText(String.valueOf(result));

                } catch (Exception e) {
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void getStart() {
        Intent rIntent = getIntent();
        currentUnitType = rIntent.getStringExtra("unit");
        System.out.println(currentUnitType);
        unitTitle.setText(currentUnitType);
        System.out.println(unitTitle);

    }


    //// TODO: 23/03/2017 try add an if statment for 'if speed convert speed units' and 'if length convert length units', might be faster?
}


