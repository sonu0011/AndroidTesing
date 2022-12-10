package com.sonu.androidtesting.exercies

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ValidPasswordTest {
    lateinit var validPassword: ValidPassword

    @Before
    fun setUp() {
        validPassword = ValidPassword()
    }

    @Test
    fun test_isValidPassword_empty_string_expected_false() {
        val result = validPassword.isValidPassword("")
        assertEquals(false, result)
    }

    @Test
    fun test_isValidPassword_invalid_length_expected_false() {
        val result = validPassword.isValidPassword("abc")
        assertEquals(false, result)
    }

    @Test
    fun test_isValidPassword_valid_input_expected_true() {
        val result = validPassword.isValidPassword("abc123")
        assertEquals(true, result)
    }

}