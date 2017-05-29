package com.example.kyle.conversionapp;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class ExampleUnitTest {

//    @Test
//    public void addition_isCorrect() throws Exception {
//        assertEquals(4, 2 + 2);
//    }

    //Tests the Convert() method
    @Test
    public void converterCreation() throws Exception {

        String currentUnitType = "Length";
        double num = 1;
        String spinner1 = "Centimetre";
        String spinner2 = "Inch";
        double res = Converter.convert(currentUnitType, num, spinner1, spinner2);
        assertTrue(res == 2.54000);
        //return res;
    }
}