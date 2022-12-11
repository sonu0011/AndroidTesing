package com.sonu.androidtesting

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class UtilTest {

    /*
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
            OR
     */

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()


    @Test
    fun test(): Unit = runTest {
        val util = Util(mainCoroutineRule.testDispatcher)
        util.checkValidInput()
        //wit for calling function to finish
        mainCoroutineRule.testDispatcher.scheduler.advanceUntilIdle()
        assertEquals(true, util.isValidInput)


    }
}