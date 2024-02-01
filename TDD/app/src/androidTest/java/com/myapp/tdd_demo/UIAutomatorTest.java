package com.myapp.tdd_demo;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

import static org.junit.Assert.assertTrue;

import android.content.Context;
import android.content.Intent;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;
import androidx.test.uiautomator.Until;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

// UIautomator Test Example
@RunWith(AndroidJUnit4.class)
public class UIAutomatorTest {

    private static final int LAUNCH_TIMEOUT = 5000;
    final String launcherPackage = "com.myapp.tdd_demo";
    private UiDevice device;

    private String text = "Welcome to CSCI3130 lab ";

    @Before
    public void setup() {
        // Get an instance of UiDevice for interacting with the device
        device = UiDevice.getInstance(getInstrumentation());

        // Get the application context
        Context context = ApplicationProvider.getApplicationContext();

        // Retrieve the launch intent for the specified package
        final Intent appIntent = context.getPackageManager().getLaunchIntentForPackage(launcherPackage);

        // Add the flag to clear the task before launching the application
        appIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

        // Start the application using the launch intent
        context.startActivity(appIntent);

        // Wait for the launcher package to be in the foreground
        device.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), LAUNCH_TIMEOUT);

    }

  @Test
   public void checkIfSwitched2WelcomePage() throws UiObjectNotFoundException {
        // input some text in the edit Text
        Espresso.onView(withId(R.id.etTextToUpdate)).perform(typeText(text));

        // Close the soft keyboard using Espresso
        Espresso.closeSoftKeyboard();

        // Perform a button click using Espresso
        Espresso.onView(withId(R.id.btn)).perform(click());

        // Now, use UiAutomator for additional checks
        UiObject welcomeLabel = new UiObject(new UiSelector().textContains("Welcome"));

        assertTrue("Welcome label exists", welcomeLabel.exists());
  }
}
