package com.sonu.androidtesting

class UserService(
    private val userRepository: UserRepository
) {
    fun loginUser(email: String, password: String): String {
        return when (userRepository.loginUser(email, password)) {
            LoginStatus.LOGIN_SUCCESS -> "User logged in successfully"
            LoginStatus.INVALID_PASSWORD -> "Invalid Password"
            LoginStatus.USER_NOT_FOUND -> "User not found"
        }
    }
}