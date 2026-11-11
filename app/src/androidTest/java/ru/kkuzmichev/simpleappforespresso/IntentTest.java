package ru.kkuzmichev.simpleappforespresso;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.espresso.intent.rule.IntentsTestRule;

import org.junit.Rule;
import org.junit.runner.RunWith;

import org.junit.Test;

import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

import static androidx.test.espresso.action.ViewActions.click;

import android.content.Intent;

import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;

import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;

@RunWith(AndroidJUnit4.class)
public class IntentTest {

    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule =
            new IntentsTestRule<>(MainActivity.class);


    @Test
    public void checkSettingsIntent() {
        openActionBarOverflowOrOptionsMenu(
                getInstrumentation().getTargetContext()
        );

        onView(withText("Settings"))
                .check(matches(isDisplayed()));

        onView(withText("Settings")).perform(click());

        intended(hasAction(Intent.ACTION_VIEW));

        intended(hasData("https://google.com"));

    }

}