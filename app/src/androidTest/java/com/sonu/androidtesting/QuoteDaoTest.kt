package com.sonu.androidtesting

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class QuoteDaoTest {

    lateinit var quoteDatabase: QuoteDatabase
    lateinit var quoteDao: QuoteDao

    @Before
    fun setup() {
        quoteDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            QuoteDatabase::class.java
        ).allowMainThreadQueries().build()

        quoteDao = quoteDatabase.getQuoteDao()
    }

    @After
    fun tearDown() {
        quoteDatabase.close()
    }

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun testInsertQuote_expected_singleQuote() = runBlocking {
        val quote = Quote(0, "title", "description")
        quoteDao.insert(quote)

        val quoteList = quoteDao.getAllQuotes().getOrAwaitValue()
        Assert.assertEquals(1, quoteList.size)
    }

    @Test
    fun testDeleteQuote_expected_noQuote() = runBlocking {
        val quote = Quote(0, "title", "description")
        quoteDao.insert(quote)
        quoteDao.delete()

        val quoteList = quoteDao.getAllQuotes().getOrAwaitValue()
        Assert.assertEquals(0, quoteList.size)
    }
}