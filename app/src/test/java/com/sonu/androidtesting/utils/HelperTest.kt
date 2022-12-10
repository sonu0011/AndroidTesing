package com.sonu.androidtesting.utils

import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class HelperTest {
    lateinit var helper: Helper

    @Before
    fun setup() {
        helper = Helper()
    }

    @After
    fun cleanUp() {
        //clean up
    }

    @Test
    fun isPalindrome() {
        //Arrange
        //val helper = Helper()
        //Act
        val result = helper.isPalindrome("a")
        //Assert
        assertEquals(true, result)
    }

    @Test
    fun isPalindrome_inputString_level_expectedTrue() {
        //Arrange
        //val helper = Helper()
        //Act
        val result = helper.isPalindrome("level")
        //Assert
        assertEquals(true, result)
    }

}