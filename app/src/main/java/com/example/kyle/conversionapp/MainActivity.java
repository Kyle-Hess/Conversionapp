package com.example.kyle.conversionapp;

import android.content.Intent;
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
    private ArrayAdapter<CharSequence> adapter1;
    private ArrayAdapter<CharSequence> adapter2;

    boolean Length;

    public String currentUnitType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unitTitle = (TextView) findViewById(R.id.unit_title);
        spinnerFrom = (Spinner) findViewById(R.id.spinner_from);
        spinnerTo = (Spinner) findViewById(R.id.spinner_to);

        adapter1 = ArrayAdapter.createFromResource(this, R.array.length_array, android.R.layout.simple_spinner_item);
        adapter2 = ArrayAdapter.createFromResource(this, R.array.speed_array, android.R.layout.simple_spinner_item);

        spinnerFrom.setAdapter(adapter1);
        spinnerTo.setAdapter(adapter1);

        inputFrom = (EditText) findViewById(R.id.input_from);
        inputTo = (EditText) findViewById(R.id.input_to);

        Intent rIntent = getIntent();
        currentUnitType = rIntent.getStringExtra("unit");
        System.out.println(currentUnitType);
        unitTitle.setText(currentUnitType);
        System.out.println(unitTitle);

        //// TODO: 19/03/2017
        try {
            switch (currentUnitType) {
                case "Length":
                    spinnerFrom.setAdapter(adapter1);
                    spinnerTo.setAdapter(adapter1);
                    unitTitle.setText(currentUnitType);
                    break;
                case "Speed":
                    spinnerFrom.setAdapter(adapter2);
                    spinnerTo.setAdapter(adapter2);
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
                }
                if (hasFocus) {
                    inputTo.getText().clear();
                }
            }
        };
        inputFrom.setOnFocusChangeListener(f);
        inputTo.setOnFocusChangeListener(f);

        //// TODO: 23/03/2017 Try and simplify the on text change input listeners into one listener
        //// TODO: 23/03/2017 Try to add an if or switch to separate Length and speed conversions for cleaner layout

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
                    double result = Converter.convert(value, spinnerUnitFrom, spinnerUnitTo);
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
                    double result = Converter.convert(value, spinnerUnitTo, spinnerUnitFrom);
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
    //// TODO: 23/03/2017 try add an if statment for 'if speed convert speed units' and 'if length convert length units', might be faster?
}


