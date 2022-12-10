package com.sonu.androidtesting.quotes

import android.content.Context
import com.google.gson.Gson

class QuotesManager {
    var quoteList = arrayOf<Quote>()
    var currentIndex = 0

    fun getQuotesFromAssets(context: Context, fileName: String) {
        val inputStream = context.assets.open(fileName)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val jsonString = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        quoteList = gson.fromJson(jsonString, Array<Quote>::class.java)
    }

    fun populateQuotes(quotes: Array<Quote>) {
        quoteList = quotes
    }

    fun getCurrentQuote(): Quote? {
        return if (quoteList.isEmpty()) null
        else quoteList[currentIndex]
    }

    fun getNextQuote(): Quote? {
        return if (quoteList.isEmpty()) null
        else {
            if (currentIndex == quoteList.size - 1) {
                quoteList[currentIndex]
            } else {
                quoteList[++currentIndex]
            }
        }
    }

    fun getPreviousQuote(): Quote? {
        return if (quoteList.isEmpty()) null
        else {
            if (currentIndex == quoteList.size - 1) {
                quoteList[currentIndex]
            } else {
                quoteList[--currentIndex]
            }
        }
    }
}