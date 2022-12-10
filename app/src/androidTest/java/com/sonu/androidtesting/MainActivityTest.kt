package com.sonu.androidtesting

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
import org.hamcrest.core.AllOf.allOf
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @get:Rule
    val activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun testNextButton_expectedCorrect_quote() {
        onView(withId(R.id.textViewNext)).perform(click())
        onView(withId(R.id.textViewNext)).perform(click())
        onView(withId(R.id.textViewNext)).perform(click())
        onView(withId(R.id.quoteText)).check(matches(withText("Difficulties increase the nearer we get to the goal.")))
        onView(withId(R.id.quoteAuthor)).check(matches(withText("Johann Wolfgang von Goethe")))
    }

    @Test
    fun testShareButton_expected_IntentChooser() {
        Intents.init()
        val expected = allOf(hasAction(Intent.ACTION_SEND))
        onView(withId(R.id.floatingActionButton)).perform(click())
        intended(expected)
        Intents.release()
    }

}