package com.example.kyle.conversionapp;

/**
 * Created by Kyle on 26/03/2017.
 */

public class Converter {

    public Converter(){
        
    }
//// TODO: 26/03/2017 Need to fix Speed conversion between km/s and m/s 
    public static double convert(double value, String spinnerUnitFrom, String spinnerUnitTo) {
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


    private double convertSpeed(double value, String spinnerUnitFrom, String spinnerUnitTo) {
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
