package com.acme.a3csci3130;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class CreatContactTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void creatContactTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction button = onView(
                allOf(withId(R.id.submitButton), withText("Create Contact"), isDisplayed()));
        button.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction editText = onView(
                allOf(withId(R.id.business), isDisplayed()));
        editText.perform(replaceText("123123123"), closeSoftKeyboard());

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.name), isDisplayed()));
        editText2.perform(replaceText("Garvit Gosain"), closeSoftKeyboard());

        ViewInteraction editText3 = onView(
                allOf(withId(R.id.pbusiness), isDisplayed()));
        editText3.perform(replaceText("Processor"), closeSoftKeyboard());

        ViewInteraction editText4 = onView(
                allOf(withId(R.id.address), isDisplayed()));
        editText4.perform(replaceText("Calgary"), closeSoftKeyboard());

        ViewInteraction editText5 = onView(
                allOf(withId(R.id.province), isDisplayed()));
        editText5.perform(replaceText("AB"), closeSoftKeyboard());

        ViewInteraction button2 = onView(
                allOf(withId(R.id.submitButton), withText("Create Business"), isDisplayed()));
        button2.perform(click());

    }

}
