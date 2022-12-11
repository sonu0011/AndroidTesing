package com.sonu.androidtesting

class UserRepository {
   private  val userList = listOf<User>(
        User("abc@gmail.com", "123456"),
        User("abc1@gmail.com", "pwd1"),
        User("abc2@gmail.com", "12345678"),
    )

    fun loginUser(email: String, password: String): LoginStatus {
        val filteredUser = userList.filter { it.email == email }
        return if (filteredUser.isEmpty()) LoginStatus.USER_NOT_FOUND
        else {
            if (filteredUser[0].password != password) LoginStatus.INVALID_PASSWORD
            else LoginStatus.LOGIN_SUCCESS
        }

    }
}

enum class LoginStatus {
    LOGIN_SUCCESS,
    INVALID_PASSWORD,
    USER_NOT_FOUND
}