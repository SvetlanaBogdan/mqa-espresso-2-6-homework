
package ru.kkuzmichev.simpleappforespresso;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.runner.RunWith;

import androidx.test.espresso.IdlingRegistry;

import org.junit.Before;
import org.junit.After;

import org.junit.Test;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;

import androidx.test.espresso.ViewInteraction;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static org.hamcrest.Matchers.allOf;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition;

@RunWith(AndroidJUnit4.class)
public class GalleryIdlingResourceTest {


        @Rule
        public ActivityTestRule<MainActivity> activityTestRule =
                new ActivityTestRule<>(MainActivity.class);

        @Before
        public void registerIdlingResource() {
            IdlingRegistry.getInstance().register(
                    EspressoIdlingResources.idlingResource
            );
        }

        @After
        public void unregisterIdlingResource() {
            IdlingRegistry.getInstance().unregister(
                    EspressoIdlingResources.idlingResource
            );
        }

    @Test
    public void checkGalleryItemSeven() {
        onView(withContentDescription("Open navigation drawer"))
                .perform(click());
        ViewInteraction gallery = onView(withId(R.id.nav_gallery));
        gallery.perform(click());
        ViewInteraction recyclerView = onView(withId(R.id.recycle_view));
        recyclerView.perform(scrollToPosition(6));
        ViewInteraction itemSeven = onView(allOf(
                withId(R.id.item_number),
                withText("7")
        ));

        itemSeven.check(matches(isDisplayed()));
    }


    }
