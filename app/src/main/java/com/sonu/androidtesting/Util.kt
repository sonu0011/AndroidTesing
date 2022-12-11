package com.sonu.androidtesting

import kotlinx.coroutines.*

/*
we should always pass dispatcher as input argument
we should not make dispatcher hard code
 */
class Util(val dispatcher: CoroutineDispatcher) {
    suspend fun getName(): String {
        delay(5000)
        getName1()
        return "Sonu"
    }

    suspend fun getName1() {
        delay(5000)
    }

    suspend fun getAddress(): String {
        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)

        }
        return "address"
    }

    suspend fun getAge(): Int {
        withContext(dispatcher) {
            delay(2000)
        }
        return 25
    }

    var isValidInput = false
    suspend fun checkValidInput() {
        CoroutineScope(dispatcher).launch {
            delay(2000)
            isValidInput = true
        }
    }

}