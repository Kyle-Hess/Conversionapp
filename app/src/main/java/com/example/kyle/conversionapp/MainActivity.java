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
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
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

        inputFrom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence string, int start, int before, int count) {

                //// TODO: 19/03/2017 Mabey try to simplify into a single method.
                //onTextConvert1(string);
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

        inputTo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence string, int start, int before, int count) {
                //onTextConvert2(string);
                try {
                    String spinnerUnitFrom = (String) spinnerFrom.getSelectedItem();
                    String spinnerUnitTo = (String) spinnerTo.getSelectedItem();
                    double value = Integer.parseInt(string.toString());
                    double result = convert(value,spinnerUnitTo, spinnerUnitFrom);
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



    private void onTextConvert1(CharSequence string) {
        try {
            switch (currentUnitType) {
                case "Length":
                    String spinnerUnitFrom = (String) spinnerFrom.getSelectedItem();
                    String spinnerUnitTo = (String) spinnerTo.getSelectedItem();
                    double value = Integer.parseInt(string.toString());
                    double result = convert(value, spinnerUnitFrom, spinnerUnitTo);
                    System.out.println(result);
                    inputTo.setText(String.valueOf(result));
                    break;
                case "Speed":
                    spinnerUnitFrom = (String) spinnerFrom.getSelectedItem();
                    spinnerUnitTo = (String) spinnerTo.getSelectedItem();
                    value = Integer.parseInt(string.toString());
                    result = convertS(value, spinnerUnitFrom, spinnerUnitTo);
                    System.out.println(result);
                    inputTo.setText(String.valueOf(result));
            }
        } catch (Exception e) {
        }

    }
    private void onTextConvert2(CharSequence string) {
        try {

            switch (currentUnitType) {
                case "Length":
                    String spinnerUnitFrom = (String) spinnerFrom.getSelectedItem();
                    String spinnerUnitTo = (String) spinnerTo.getSelectedItem();
                    double value = Integer.parseInt(string.toString());
                    double result = convert(value, spinnerUnitTo, spinnerUnitFrom);
                    System.out.println(result);
                    inputFrom.setText(String.valueOf(result));
                    break;
                case "Speed":
                    spinnerUnitFrom = (String) spinnerFrom.getSelectedItem();
                    spinnerUnitTo = (String) spinnerTo.getSelectedItem();
                    value = Integer.parseInt(string.toString());
                    result = convertS(value, spinnerUnitTo, spinnerUnitFrom);
                    System.out.println(result);
                    inputFrom.setText(String.valueOf(result));
            }
        } catch (Exception e) {
        }
    }



//    TextWatcher tw = new TextWatcher() {
//        @Override
//        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//        }
//
//        @Override
//        public void onTextChanged(CharSequence string, int start, int before, int count) {
//            try {
//                //// TODO: 19/03/2017 Mabey try to simplify into a single method.
//                String spinnerUnitFrom = (String) spinnerFrom.getSelectedItem();
//                String spinnerUnitTo = (String) spinnerTo.getSelectedItem();
//                double value = Integer.parseInt(string.toString());
//                double result = convert(value, spinnerUnitFrom, spinnerUnitTo);
//                System.out.println(result);
//                inputTo.setText(String.valueOf(result));
//            } catch (Exception e) {
//            }
//        }
//
//        @Override
//        public void afterTextChanged(Editable s) {
//
//        }
//    };
//// TODO: 23/03/2017 try add an if statment for 'if speed convert speed units' and 'if length convert length units', might be faster?
    private double convert(double value, String spinnerUnitFrom, String spinnerUnitTo) {
//// TODO: 19/03/2017 find better naming for spinnerUnit...
        double num1 = value;
        double num2 = 0;

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
                        num2 = num1 *2.54;
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
                        break;
                }
                break;
            }
            //Speed Conversion
            case "Kilometres per hour": {
                switch (spinnerUnitTo) {
                    case "Kilometres per hour":
                        num2 = num1;
                        break;
                    case "Metres per second":
                        num2 = num1 * 0.277778;
                        break;
                    case "Miles per hour":
                        num2 = num1 * 0.621371;
                        break;
                }
                break;
            }
            case "Metres per second": {
                switch (spinnerUnitTo) {
                    case "Metres per second":
                        num2 = num1;
                        break;
                    case "Kilometres per hour":
                        num2 = num1 * 3.6;
                        break;

                    case "Miles per hour":
                        num2 = num1 * 2.23694;
                        break;
                }
                break;
            }
            case "Miles per hour": {
                switch (spinnerUnitTo) {
                    case "Miles per hour":
                        num2 = num1;
                        break;
                    case "Kilometres per hour":
                        num2 = num1 * 1.60934;
                        break;
                    case "Metres per second":
                        num2 = num1 * 0.44704;
                        break;
                }
                break;
            }
        }
        return num2;
    }

    private double convertS(double value, String spinnerUnitFrom, String spinnerUnitTo) {
        double num1 = value;
        double num2 = 0;

        switch (spinnerUnitFrom) {
            //Speed Conversion
            case "Kilometres per hour": {
                switch (spinnerUnitTo) {
                    case "Kilometres per hour":
                        num2 = num1;
                        break;
                    case "Metres per second":
                        num2 = num1 * 0.277778;
                        break;
                    case "Miles per hour":
                        num2 = num1 * 0.621371;
                        break;
                }
                break;
            }
            case "Metres per second": {
                switch (spinnerUnitTo) {
                    case "Metres per second":
                        num2 = num1;
                        break;
                    case "Kilometres per hour":
                        num2 = num1 * 3.6;
                        break;

                    case "Miles per hour":
                        num2 = num1 * 2.23694;
                        break;
                }
                break;
            }
            case "Miles per hour": {
                switch (spinnerUnitTo) {
                    case "Miles per hour":
                        num2 = num1;
                        break;
                    case "Kilometres per hour":
                        num2 = num1 * 1.60934;
                        break;
                    case "Metres per second":
                        num2 = num1 * 0.44704;
                        break;
                }
                break;
            }
        }
        return num2;
    }
}


