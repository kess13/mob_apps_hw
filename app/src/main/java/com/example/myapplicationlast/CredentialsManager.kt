package com.example.myapplicationlast
import android.util.Patterns

class CredentialsManager {

    fun isValidEmail(email: String): Boolean {
        return email.isNotEmpty() && email.contains("@") && email.contains(".")
    }

    fun isValidPassword(password: String): Boolean {
        return password.isNotEmpty() && password.length >= 8
    }

    private val existingUsers = listOf(
        "user1@gmail.com",
        "user2@tt.com",
        "user3@test.com"
    )

    fun isUserAlreadyRegistered(email: String): Boolean {
        return existingUsers.contains(email)
    }


}


