package com.myapp.tdd_demo;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

// Espresso Test Example

public class EspressoTest {

    //what activity you want to run it on
    @Rule
    public ActivityScenarioRule<MainActivity> activityTestRule = new ActivityScenarioRule<>(MainActivity.class);

    private String text = "Welcome to CSCI3130 lab ";

    //preprocessing before the test, eg if the resources are available
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void userInputScenarioTest(){
        // input some text in the edit Text
        //here the view is the edit text field, performing type, and entering the text we initialized
        Espresso.onView(withId(R.id.etTextToUpdate)).perform(typeText(text));
        // Close the soft Keyboard
        Espresso.closeSoftKeyboard();
        // perform Button Click
        Espresso.onView(withId(R.id.btn)).perform(click());
        // Checking the text in the textView
        Espresso.onView(withId(R.id.tvChangedText)).check(matches(withText(text)));


    }

    // to release the resources
    @After
    public void tearDown() throws Exception {
    }
}