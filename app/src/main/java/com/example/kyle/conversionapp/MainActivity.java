package com.example.kyle.conversionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerFrom;
    private Spinner spinnerTo;
    private EditText inputFrom;
    private EditText inputTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerFrom = (Spinner) findViewById(R.id.spinner_from);
        spinnerTo = (Spinner) findViewById(R.id.spinner_to);
        inputFrom = (EditText) findViewById(R.id.input_from);
        inputTo = (EditText) findViewById(R.id.input_to);


        //Button to Unit selection screen
        Button unitButton = (Button) findViewById(R.id.button);
        unitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        //Input Listener for Input_from
        inputFrom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence string, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence string, int start, int before, int count) {
                try {
                    String spinnerUnitFrom = (String) spinnerFrom.getSelectedItem();
                    String spinnerUnitTo = (String) spinnerTo.getSelectedItem();
                    double value = Integer.parseInt(string.toString());
                    double result = convert(value, spinnerUnitFrom, spinnerUnitTo);
                    System.out.println(result);
                    inputTo.setText(String.valueOf(result));
                } catch (Exception e) {
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //Input Listener for input_to
        inputTo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence string, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence string, int start, int before, int count) {
                try {
                    String spinnerUnitFrom = (String) spinnerFrom.getSelectedItem();
                    String spinnerUnitTo = (String) spinnerTo.getSelectedItem();
                    double value = Integer.parseInt(string.toString());
                    double result = convert(value, spinnerUnitFrom, spinnerUnitTo);
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

    private double convert(double value, String spinnerUnitFrom, String spinnerUnitTo) {

        double num1 = value;
        double num2 = 0.0;

        String from = spinnerUnitFrom;
        String to = spinnerUnitTo;

        switch (from) {
            case "Metre": {
                switch (to) {
                    case "Metre":
                        num2 = num1;
                        break;
                    case "Centimetre":
                        num2 = num1 * 100;
                        break;
                    case "Inches":
                        num2 = num1 * 39.3701;
                        break;
                }
                break;
            }
            case "Centimetre": {
                switch (to) {
                    case "Centimetre":
                        num2 = num1;
                        break;
                    case "Metre":
                        num2 = num1 / 100;
                        break;
                    case "Inches":
                        num2 = num1 * 2.54;
                        break;
                }
                break;
            }
            case "Inches": {
                switch (to) {
                    case "Inches":
                        num2 = num1;
                        break;
                    case "Metre":
                        num2 = num1 * 0.0254;
                        break;
                    case "Centimetre":
                        num2 = num1 * 2.54;
                }
                break;
            }
        }
        return num2;
    }
}


