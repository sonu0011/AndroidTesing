package com.sonu.androidtesting.exercies
/*
    should not be empty
    Length should be between 6 and 15
    Otherwise return valid password
 */

class ValidPassword {
    fun isValidPassword(input: String): Boolean {
        if (input.isBlank()) return false
        if (input.length !in 6..15) return false
        return true
    }
}