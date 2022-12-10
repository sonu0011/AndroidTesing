package com.sonu.androidtesting.utils

class Helper {
    fun isPalindrome(input: String): Boolean {
        var result: Boolean = true
        var startIndex = 0
        var endIndex = input.length - 1
        while (startIndex <= endIndex) {
            if (input[startIndex++] != input[endIndex--]) {
                result = false
                break
            }

        }
        return result
    }
}