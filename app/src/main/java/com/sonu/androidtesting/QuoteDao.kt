package com.sonu.androidtesting

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface QuoteDao {
    @Insert
    suspend fun insert(quote: Quote)

    @Update
    suspend fun update(quote: Quote)

    @Query("DELETE  FROM quote")
    suspend fun delete()

    @Query("SELECT * from quote")
    fun getAllQuotes(): LiveData<List<Quote>>

    @Query("SELECT * from quote where id = :quoteId")
    fun getQuoteById(quoteId: Int): Quote




}