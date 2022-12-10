package com.sonu.androidtesting.utils

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class ParameterizedTestExample(val input: String, val expected: Boolean) {

    @Test
    fun test() {
        val helper = Helper()
        val result = helper.isPalindrome(input)
        assertEquals(expected, result)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index} : {0} is palindrome {1}")
        fun data(): List<Array<Any>> {
            return listOf(
                arrayOf("level", true),
                arrayOf("test", false),
                arrayOf("", true),
                arrayOf("a", true),
            )
        }
    }

}