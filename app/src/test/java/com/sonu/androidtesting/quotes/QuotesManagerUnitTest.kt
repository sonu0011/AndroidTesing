package com.sonu.androidtesting.quotes

import android.content.Context
import android.content.res.AssetManager
import com.nhaarman.mockitokotlin2.doReturn
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/*
    Convert Instrumented test to unit test by mocking context
 */
class QuotesManagerUnitTest {
    @Mock
    lateinit var context: Context

    @Mock
    lateinit var assetManager: AssetManager

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun testGetQuotesFromAssets() {
        val testStream = this::class.java.getResourceAsStream("/quotes.json")
        doReturn(assetManager).`when`(context).assets
        Mockito.`when`(context.assets.open(anyString())).thenReturn(testStream)

        val qm = QuotesManager()
        qm.getQuotesFromAssets(context, "")

        val quote = qm.getCurrentQuote()
        assertEquals("title1", quote?.text)
        assertEquals("description", quote?.description)

    }
}