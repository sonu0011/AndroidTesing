package com.sonu.androidtesting.quotes

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.gson.JsonSyntaxException
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.io.FileNotFoundException

class QuotesManagerTest {

    @Test(expected = FileNotFoundException::class)
    fun getQuotesFromAssets() {
        val quoteManager = QuotesManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.getQuotesFromAssets(context, "")
    }

    @Test(expected = JsonSyntaxException::class)
    fun test_getQuotesFromAssets_InvalidJson_expectedException() {
        val quoteManager = QuotesManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.getQuotesFromAssets(context, "malformedQuotes.json")
    }

    @Test
    fun test_getQuotesFromAssets_ValidJson_expected_correct_count() {
        val quoteManager = QuotesManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.getQuotesFromAssets(context, "quotes.json")
        assertEquals(6, quoteManager.quoteList.size)
    }

    @Test
    fun test_getCurrentQuote_expected_correctQuote() {
        val quoteManager = QuotesManager()
        quoteManager.populateQuotes(
            arrayOf(Quote("test", "description"))
        )
        val quote = quoteManager.getCurrentQuote()
        assertNotNull(quote)
        assertEquals("test", quote?.text)
        assertEquals("description", quote?.description)
    }

    @Test
    fun test_getPreviousQuote_expected_correctQuote() {
        val quoteManager = QuotesManager()
        quoteManager.populateQuotes(
            arrayOf(
                Quote("test", "description"),
                Quote("test1", "description1"),
                Quote("test", "description"),
            )
        )
        quoteManager.getNextQuote()
        val quote = quoteManager.getPreviousQuote()
        assertNotNull(quote)
        assertEquals("test", quote?.text)
        assertEquals("description", quote?.description)
    }

    @Test
    fun test_getNextQuote_expected_correctQuote() {
        val quoteManager = QuotesManager()
        quoteManager.populateQuotes(
            arrayOf(
                Quote("test", "description"),
                Quote("test1", "description1"),
                Quote("test2", "description2"),
            )
        )
        val quote = quoteManager.getNextQuote()
        assertNotNull(quote)
        assertEquals("test1", quote?.text)
        assertEquals("description1", quote?.description)
    }

}