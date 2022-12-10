package com.sonu.androidtesting

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class NoteActivityTest {

/*
    @get:Rule
    val noteActivityScenarioRule = activityScenarioRule<NoteActivity>()

    @Test
    fun testSubmitButtonClick_expected_correctValue() {
        onView(withId(R.id.textViewTitle1)).perform(typeText("title"))
        onView(withId(R.id.textVieDescription)).perform(
            typeText("Description"),
            closeSoftKeyboard()
        )

        onView(withId(R.id.buttonSubmit)).perform(click())
        onView(withId(R.id.secondActivityDesc)).check(matches(withText("SecondActivityDescription")))
    }

 */
}