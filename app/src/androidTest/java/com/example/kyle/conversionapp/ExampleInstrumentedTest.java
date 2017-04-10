package com.example.kyle.conversionapp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.hamcrest.object.HasToString.hasToString;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.kyle.conversionapp", appContext.getPackageName());
    }

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<MainActivity>(MainActivity.class);

    //Tests the converting between two units of measurement
    @Test
    public void amount() throws Exception {
        onView(withId(R.id.input_from)).perform(typeText("1"));
        onView(withId(R.id.input_to)).check(matches(withText("1.000000")));
    }

    //Tests the selection of a unit in the spinner
    @Test
    public void spinnerSet() throws Exception {
        onView(withId(R.id.spinner_to)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Inch"))).perform(click());
        onView(withId(R.id.spinner_to)).check(matches(withSpinnerText(containsString("Inch"))));
    }

//    @Test
//    public void unitSelect() throws Exception {
//        onView(withId(R.id.unit_group)).perform(click());
//        onView(withId(R.id.unit_group)).check(matches((withText("Speed"))));
//    }
}
