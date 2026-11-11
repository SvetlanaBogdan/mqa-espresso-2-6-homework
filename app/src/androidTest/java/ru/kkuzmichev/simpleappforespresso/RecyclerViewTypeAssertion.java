package ru.kkuzmichev.simpleappforespresso;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewAssertion;

import static org.junit.Assert.assertTrue;

public class RecyclerViewTypeAssertion implements ViewAssertion {
    @Override
    public void check(View view, NoMatchingViewException noViewFoundException) {
        assertTrue(view instanceof RecyclerView);
    }
}
