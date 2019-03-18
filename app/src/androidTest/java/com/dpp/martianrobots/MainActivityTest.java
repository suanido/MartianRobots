package com.dpp.martianrobots;

import android.support.test.espresso.Espresso;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkDataInUI() {
        // Type text and then press the button.
        onView(withId(R.id.tiet_upper_rigth_coodinates))
                .perform(typeText("5 3"), closeSoftKeyboard());

        onView(withId(R.id.tiet_initial_coordinates))
                .perform(typeText("1 1"), closeSoftKeyboard());

        onView(withId(R.id.tiet_orientation))
                .perform(typeText("E"), closeSoftKeyboard());

        onView(withId(R.id.tiet_input))
                .perform(typeText("RFRFRFRF"), closeSoftKeyboard());

        onView(withId(R.id.btn_submit)).perform(click());

        onView(withId(R.id.tv_output))
                .check(matches(withText("1 1 E")));


        onView(withId(R.id.tiet_initial_coordinates))
                .perform(replaceText("3 2"), closeSoftKeyboard());

        onView(withId(R.id.tiet_orientation))
                .perform(replaceText("N"), closeSoftKeyboard());

        onView(withId(R.id.tiet_input))
                .perform(replaceText("FRRFLLFFRRFLL"), closeSoftKeyboard());

        onView(withId(R.id.btn_submit)).perform(click());

        onView(withId(R.id.tv_output))
                .check(matches(withText("3 3 N LOST")));

        onView(withId(R.id.tiet_initial_coordinates))
                .perform(replaceText("0 3"), closeSoftKeyboard());

        onView(withId(R.id.tiet_orientation))
                .perform(replaceText("W"), closeSoftKeyboard());

        onView(withId(R.id.tiet_input))
                .perform(replaceText("LLFFFLFLFL"), closeSoftKeyboard());

        onView(withId(R.id.btn_submit)).perform(click());

        onView(withId(R.id.tv_output))
                .check(matches(withText("2 3 S")));
    }

}

