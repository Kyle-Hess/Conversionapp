package com.kyle.app.conversionapp;

import android.widget.Spinner;
import android.widget.TextView;

import java.text.CollationElementIterator;
import java.text.StringCharacterIterator;

/**
 * Created by Kyle on 25/03/2017.
 */

//class for testing or, storing test methods.
public class testMethods {
    private TextView unitTitle;
    private Spinner spinnerFrom;
    private Spinner spinnerTo;
    private String currentUnitType;
    private StringCharacterIterator inputTo;
    private CollationElementIterator inputFrom;

    private void onTextConvert1(double value) {

        String spinnerUnitFrom = (String) spinnerFrom.getSelectedItem();
        String spinnerUnitTo = (String) spinnerTo.getSelectedItem();
        try {
            switch (currentUnitType) {
                case "Length":
                    double result = convert(value, spinnerUnitFrom, spinnerUnitTo);
                    System.out.println(result);
                    inputTo.setText(String.valueOf(result));
                    break;
                case "Speed":
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

    //convert method with unit checks
    private double convert(double value, String spinnerUnitFrom, String spinnerUnitTo) {
        double num1 = value;
        double num2 = 0;

        switch (unitTitle.getText().toString()) {
            case "Length": {
                System.out.println("length found");
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
                                num2 = num1 * 2.54;
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
                }
            }
            case "Speed": {
                System.out.println("speed found");

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
