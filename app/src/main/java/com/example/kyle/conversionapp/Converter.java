package com.example.kyle.conversionapp;

import android.widget.Switch;

/**
 * Created by Kyle on 26/03/2017.
 */

public class Converter {

    public Converter() {
    }

    public static double convert(String currentUnitType, double value, String spinnerUnitFrom, String spinnerUnitTo) {
//// TODO: 19/03/2017 find better naming for spinnerUnit...
        String unitType = currentUnitType;
        double num1 = value;
        double num2 = 0.0;
//Length conversion
        if (unitType.equals("Length")) {
            switch (spinnerUnitFrom) {
                case "Kilometre": {
                    switch (spinnerUnitTo) {
                        case "Kilometre":
                            num2 = num1;
                            break;
                        case "Metre":
                            num2 = num1 * 1000.0;
                            break;
                        case "Centimetre":
                            num2 = num1 * 1e+5;
                            break;
                        case "Millimetre":
                            num2 = num1 / 1e+6;
                            break;
                        case "Mile":
                            num2 = num1 / 1.60934;
                            break;
                        case "Yard":
                            num2 = num1 * 1093.61;
                            break;
                        case "Foot":
                            num2 = num1 * 3280.84;
                            break;
                        case "Inch":
                            num2 = num1 * 39370.1;
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
                            num2 = num1 * 0.001;
                            break;
                        case "Centimetre":
                            num2 = num1 * 100.0;
                            break;
                        case "Millimetre":
                            num2 = num1 * 1000.0;
                            break;
                        case "Mile":
                            num2 = num1 / 1609.34;
                            break;
                        case "Yard":
                            num2 = num1 * 1.09361;
                            break;
                        case "Foot":
                            num2 = num1 * 3.28084;
                            break;
                        case "Inch":
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
                        case "Kilometre":
                            num2 = num1 * 1e-5;
                            break;
                        case "Metre":
                            num2 = num1 * 0.01;
                            break;
                        case "Millimetre":
                            num2 = num1 * 10.0;
                            break;
                        case "Mile":
                            num2 = num1 / 160934.0;
                            break;
                        case "Yard":
                            num2 = num1 / 91.44;
                            break;
                        case "Foot":
                            num2 = num1 / 30.48;
                            break;
                        case "Inch":
                            num2 = num1 * 2.54;
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
                            num2 = num1 * 0.001;
                            break;
                        case "Centimetre":
                            num2 = num1 * 0.1;
                            break;
                        case "Mile":
                            num2 = num1 / 1609000.0;
                            break;
                        case "Yard":
                            num2 = num1 / 914.4;
                            break;
                        case "Foot":
                            num2 = num1 / 304.8;
                            break;
                        case "Inch":
                            num2 = num1 * 25.4;
                            break;
                    }
                    break;
                }
                case "Mile": {
                    switch (spinnerUnitTo) {
                        case "Mile":
                            num2 = num1;
                            break;
                        case "Kilometre":
                            num2 = num1 * 1.60934;
                            break;
                        case "Meter":
                            num2 = num1 * 1609.34;
                            break;
                        case "Centimetre":
                            num2 = num1 * 160934.0;
                            break;
                        case "Millimetre":
                            num2 = num1 * 1609340.0;
                            break;
                        case "Yard":
                            num2 = num1 * 1760.0;
                            break;
                        case "Foot":
                            num2 = num1 * 5280.0;
                            break;
                        case "Inch":
                            num2 = num1 * 6330.0;
                            break;
                    }
                    break;
                }
                case "Yard": {
                    switch (spinnerUnitTo) {
                        case "Yard":
                            num2 = num1;
                            break;
                        case "Kilometre":
                            num2 = num1 / 1093.61;
                            break;
                        case "Meter":
                            num2 = num1 * 0.9144;
                            break;
                        case "Centimetre":
                            num2 = num1 * 91.44;
                            break;
                        case "Millimetre":
                            num2 = num1 * 914.4;
                            break;
                        case "Mile":
                            num2 = num1 / 1760.0;
                            break;
                        case "Foot":
                            num2 = num1 * 3.0;
                            break;
                        case "Inch":
                            num2 = num1 * 36.0;
                            break;
                    }
                    break;
                }
                case "Foot": {
                    switch (spinnerUnitTo) {
                        case "Foot":
                            num2 = num1;
                            break;
                        case "Kilometre":
                            num2 = num1 * 0.0003048;
                            break;
                        case "Meter":
                            num2 = num1 * 0.3048;
                            break;
                        case "Centimetre":
                            num2 = num1 * 30.48;
                            break;
                        case "Millimetre":
                            num2 = num1 * 304.8;
                            break;
                        case "Mile":
                            num2 = num1 / 5280.0;
                            break;
                        case "Yard":
                            num2 = num1 / 3.0;
                            break;
                        case "Inch":
                            num2 = num1 * 12.0;
                            break;
                    }
                    break;
                }
                case "Inch": {
                    switch (spinnerUnitTo) {
                        case "Inch":
                            num2 = num1;
                            break;
                        case "Kilometre":
                            num2 = num1 * 0.0000254;
                            break;
                        case "Metre":
                            num2 = num1 * 0.0254;
                            break;
                        case "Centimetre":
                            num2 = num1 * 2.54;
                            break;
                        case "Millimetre":
                            num2 = num1 * 25.4;
                            break;
                        case "Mile":
                            num2 = num1 / 63360.0;
                            break;
                        case "Yard":
                            num2 = num1 / 36.0;
                            break;
                        case "Foot":
                            num2 = num1 / 12.0;
                            break;
                    }
                    break;
                }
            }
            return num2;

//Speed Conversion
        } else if (unitType.equals("Speed")) {
            switch (spinnerUnitFrom) {
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
        }return num2;
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
