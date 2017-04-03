package com.example.kyle.conversionapp;

import android.widget.Switch;

/**
 * Created by Kyle on 26/03/2017.
 */

public class Converter {

    public Converter(){

    }

    //// TODO: 26/03/2017 Need to fix Speed conversion between km/s and m/s
    public static double convert(String currentUnitType, double value, String spinnerUnitFrom, String spinnerUnitTo) {
//// TODO: 19/03/2017 find better naming for spinnerUnit...
        String unitType = currentUnitType;
        double num1 = value;
        double num2 = 0.0d;

        if (unitType.equals("Length")){

            switch (spinnerUnitFrom) {
                case "Kilometre": {
                    switch (spinnerUnitTo) {
                        case "Kilometre":
                            num2 = num1;
                            break;
                        case "Metre":
                            num2 = num1 * 1000.0d;
                            break;
                        case "Centimetre":
                            num2 = num1 * 1e+5d;
                            break;
                        case "Millimetre":
                            num2 = num1 / 1e+6;
                            break;
                        case "Mile":
                            num2 = num1 / 1.60934d;
                            break;
                        case "Yard":
                            num2 = num1 * 1093.61d;
                            break;
                        case "Foot":
                            num2 = num1 * 3280.84d;
                            break;
                        case "Inch":
                            num2 = num1 * 39370.1d;
                            break;
                    }
                    break;
                }

                case "Metre": {
                    switch (spinnerUnitTo) {
                        case "Metre":
                            num2 = num1;
                            break;
                        case "Kilometre":
                            num2 = num1 * 0.001d;
                            break;
                        case "Centimetre":
                            num2 = num1 * 100.0d;
                            break;
                        case "Millimetre":
                            num2 = num1 * 1000.0d;
                            break;
                        case "Mile":
                            num2 = num1 / 1609.34d;
                            break;
                        case "Yard":
                            num2 = num1 * 1.09361d;
                            break;
                        case "Foot":
                            num2 = num1 * 3.28084d;
                            break;
                        case "Inch":
                            num2 = num1 * 39.3701d;
                            break;
                    }
                    break;
                }
                case "Centimetre": {
                    switch (spinnerUnitTo) {
                        case "Centimetre":
                            num2 = num1;
                            break;
                        case "Kilometre":
                            num2 = num1 * 1e-5;
                            break;
                        case "Metre":
                            num2 = num1 * 0.01d;
                            break;
                        case "Millimetre":
                            num2 = num1 * 10.0d;
                            break;
                        case "Mile":
                            num2 = num1 / 160934.0d;
                            break;
                        case "Yard":
                            num2 = num1 / 91.44d;
                            break;
                        case "Foot":
                            num2 = num1 / 30.48d;
                            break;
                        case "Inch":
                            num2 = num1 * 2.54d;
                            break;
                    }
                    break;
                }
                case "Millimetre": {
                    switch (spinnerUnitTo) {
                        case "Millimetre":
                            num2 = num1;
                            break;
                        case "Kilometre":
                            num2 = num1 * 1e-6;
                            break;
                        case "Metre":
                            num2 = num1 * 0.001d;
                            break;
                        case "Centimetre":
                            num2 = num1 * 0.1d;
                            break;
                        case "Mile":
                            num2 = num1 / 1609000.0d;
                            break;
                        case "Yard":
                            num2 = num1 / 914.4d;
                            break;
                        case "Foot":
                            num2 = num1 / 304.8d;
                            break;
                        case "Inch":
                            num2 = num1 * 25.4d;
                            break;
                    }
                    break;
                }
                case "Mile": {
                    switch (spinnerUnitTo) {
                        case "Mile":
                            num2 = num1;
                            break;
                        case "Kilometer":
                            num2 = num1 * 1.60934d;
                            break;
                        case "Meter":
                            num2 = num1 * 1609.34d;
                            break;
                        case "Centimeter":
                            num2 = num1 * 160934.0d;
                            break;
                        case "Millimeter":
                            num2 = num1 * 1609340.0d;
                            break;
                        case "Yard":
                            num2 = num1 * 1760.0d;
                            break;
                        case "Foot":
                            num2 = num1 * 5280.0d;
                            break;
                        case "Inch":
                            num2 = num1 * 6330.0d;
                            break;
                    }
                    break;
                }
                case "Yard": {
                    switch (spinnerUnitTo) {
                        case "Yard":
                            num2 = num1;
                            break;
                        case "Kilometer":
                            num2 = num1 / 1093.61d;
                            break;
                        case "Meter":
                            num2 = num1 * 0.9144d;
                            break;
                        case "Centimeter":
                            num2 = num1 * 91.44d;
                            break;
                        case "Millimeter":
                            num2 = num1 * 914.4d;
                            break;
                        case "Mile":
                            num2 = num1 / 1760.0d;
                            break;
                        case "Foot":
                            num2 = num1 * 3.0d;
                            break;
                        case "Inch":
                            num2 = num1 * 36.0d;
                            break;
                    }
                    break;
                }
                case "Foot": {
                    switch (spinnerUnitTo) {
                        case "Foot":
                            num2 = num1;
                            break;
                        case "Kilometer":
                            num2 = num1 * 0.0003048d;
                            break;
                        case "Meter":
                            num2 = num1 * 0.3048d;
                            break;
                        case "Centimeter":
                            num2 = num1 * 30.48d;
                            break;
                        case "Millimeter":
                            num2 = num1 * 304.8d;
                            break;
                        case "Mile":
                            num2 = num1 / 5280.0d;
                            break;
                        case "Yard":
                            num2 = num1 / 3.0d;
                            break;
                        case "Inch":
                            num2 = num1 * 12.0d;
                            break;
                    }
                    break;
                }
                case "Inch": {
                    switch (spinnerUnitTo) {
                        case "Inch":
                            num2 = num1;
                            break;
                        case "Kilometer":
                            num2 = num1 * 0.0000254d;
                            break;
                        case "Metre":
                            num2 = num1 * 0.0254d;
                            break;
                        case "Centimetre":
                            num2 = num1 * 2.54d;
                            break;
                        case "Millimeter":
                            num2 = num1 * 25.4d;
                            break;
                        case "Mile":
                            num2 = num1 / 63360.0d;
                            break;
                        case "Yard":
                            num2 = num1 / 36.0d;
                            break;
                        case "Foot":
                            num2 = num1 / 12.0d;
                            break;
                    }
                    break;
                }
            }
            return num2;

        } else if (unitType.equals("Speed")){
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
        return num2;
    }
//Speed Conversion
//        switch (spinnerUnitFrom) {
//
//            case "Kilometres per hour": {
//                switch (spinnerUnitTo) {
//                    case "Kilometres per hour":
//                        num2 = num1;
//                        break;
//                    case "Metres per second":
//                        num2 = num1 * 0.277778;
//                        break;
//                    case "Miles per hour":
//                        num2 = num1 * 0.621371;
//                        break;
//                }
//                break;
//            }
//            case "Metres per second": {
//                switch (spinnerUnitTo) {
//                    case "Metres per second":
//                        num2 = num1;
//                        break;
//                    case "Kilometres per hour":
//                        num2 = num1 * 3.6;
//                        break;
//
//                    case "Miles per hour":
//                        num2 = num1 * 2.23694;
//                        break;
//                }
//                break;
//            }
//            case "Miles per hour": {
//                switch (spinnerUnitTo) {
//                    case "Miles per hour":
//                        num2 = num1;
//                        break;
//                    case "Kilometres per hour":
//                        num2 = num1 * 1.60934;
//                        break;
//                    case "Metres per second":
//                        num2 = num1 * 0.44704;
//                        break;
//                }
//                break;
//            }
//        }
//        return num2;
//    }


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
