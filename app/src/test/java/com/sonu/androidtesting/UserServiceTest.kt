package com.sonu.androidtesting

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class UserServiceTest {
    @Mock
    lateinit var repository: UserRepository

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)

        //define behaviour
        Mockito.`when`(repository.loginUser(anyString(), anyString())).thenReturn(
            LoginStatus.INVALID_PASSWORD
        )
    }

    @Test
    fun testLoginUser_expected_invalidPassword() {
        val userService = UserService(repository)
        val result = userService.loginUser("skr", "123")
        assertEquals("Invalid Password", result)

    }
}