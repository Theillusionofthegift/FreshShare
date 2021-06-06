package com.example.freshshare;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)

public class SignUpTest {
    @Rule
    public ActivityScenarioRule<SignUpActivity> activityScenarioRule
            = new ActivityScenarioRule<>(SignUpActivity.class);

    @Test
    public void profileFieldsRequired() {
        onView(withId(R.id.vendor)).perform(typeText(""));
        onView(withId(R.id.email)).perform(typeText(""));
        onView(withId(R.id.address)).perform(typeText(""));
        onView(withId(R.id.password)).perform(typeText(""));

        onView(withId(R.id.sign_up_button)).perform(scrollTo(),click());

        onView(allOf(withId(R.id.vendor), hasErrorText("Please Enter Vendor Name")));
        onView(allOf(withId(R.id.email), hasErrorText("Please Enter Valid Email")));
        onView(allOf(withId(R.id.address), hasErrorText("Please Enter address")));
        onView(allOf(withId(R.id.password), hasErrorText("Please Set Password")));
    }

}
