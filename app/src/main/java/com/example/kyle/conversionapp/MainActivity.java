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
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView unitTitle;
    public Spinner spinnerFrom;
    private Spinner spinnerTo;
    private EditText inputFrom;
    private EditText inputTo;
    private ArrayAdapter<CharSequence>adapter1;
    private ArrayAdapter<CharSequence>adapter2;

    public String currentUnitType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unitTitle = (TextView) findViewById(R.id.unit_title);
        spinnerFrom = (Spinner) findViewById(R.id.spinner_from);
        spinnerTo = (Spinner) findViewById(R.id.spinner_to);
        //ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.length_array, android.R.layout.simple_spinner_item);
        //ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.speed_array, android.R.layout.simple_spinner_item);

        adapter1 = ArrayAdapter.createFromResource(this, R.array.length_array, android.R.layout.simple_spinner_item);
        adapter2 = ArrayAdapter.createFromResource(this, R.array.speed_array, android.R.layout.simple_spinner_item);

        spinnerFrom.setAdapter(adapter1);
        spinnerTo.setAdapter(adapter1);

        inputFrom = (EditText) findViewById(R.id.input_from);
        inputTo = (EditText) findViewById(R.id.input_to);

        Intent rIntent = getIntent();
        currentUnitType = rIntent.getStringExtra("unit");
        System.out.println(currentUnitType);
        //// TODO: 19/03/2017 put the below switch statement into a method?
        try {
            switch (currentUnitType){
                case "length":
                    spinnerFrom.setAdapter(adapter1);
                    spinnerTo.setAdapter(adapter1);
                    unitTitle.setText("Length");
                    break;
                case "speed":
                    spinnerFrom.setAdapter(adapter2);
                    spinnerTo.setAdapter(adapter2);
                    unitTitle.setText("Speed");
                    break;
        }
        }catch (Exception e){

        }

        //Button to Unit selection screen
        Button unitButton = (Button) findViewById(R.id.button);
        unitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                //intent.putExtra();
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
                    //// TODO: 19/03/2017 Mabey try to simplify into a single method.
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
//// TODO: 19/03/2017 find better naming for spinnerUnit...
        double num1 = value;
        double num2 = 0.0;

        switch (spinnerUnitFrom) {
            case "Metre": {
                switch (spinnerUnitTo) {
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
                switch (spinnerUnitTo) {
                    case "Centimetre":
                        num2 = num1;
                        break;
                    case "Metre":
                        num2 = num1 / 100;
                        break;
                    case "Inches":
                        num2 = num1 * 0.393701;
                        break;
                }
                break;
            }
            case "Inches": {
                switch (spinnerUnitTo) {
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

    public void dataAdapter(String text){
//// TODO: 19/03/2017 try to use intent
        if (text.equals("length")){
            spinnerFrom.setAdapter(adapter1);
            spinnerTo.setAdapter(adapter1);
        }else if (text.equals("speed")){
            spinnerFrom.setAdapter(adapter2);
            spinnerTo.setAdapter(adapter2);
        }
    }
}


