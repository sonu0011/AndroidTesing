package com.sonu.androidtesting

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Quote::class], version = 1)
abstract class QuoteDatabase  : RoomDatabase(){
   abstract fun getQuoteDao(): QuoteDao
}