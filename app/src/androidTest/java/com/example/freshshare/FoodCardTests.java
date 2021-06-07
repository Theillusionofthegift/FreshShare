package com.example.freshshare;

import android.view.View;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.contrib.DrawerActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)

public class FoodCardTests {
    @Rule
    public ActivityScenarioRule<MainActivity> rule
            = new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test
    public void checkRecyclerView() throws InterruptedException {
        Thread.sleep(1000);
        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.scrollToPosition(1));
        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(1, new ClickOnImage()));
        Thread.sleep(1000);
        onView(withId(R.id.foodName)).check(matches(withText("Shallow-Fried Garlic & Onion Yak")));
    }


    public static class ClickOnImage implements ViewAction {

        ViewAction c = click();

        @Override
        public Matcher<View> getConstraints() {
            return c.getConstraints();
        }

        @Override
        public String getDescription() {
            return "Click on a child view with specified id.";
        }

        @Override
        public void perform(UiController uiController, View view) {
            c.perform(uiController,view.findViewById(R.id.match_image));
        }
    }

}