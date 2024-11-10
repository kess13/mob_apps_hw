package com.example.myapplicationlast
import android.util.Patterns

class CredentialsManager {
    fun isEmailValid(email: String): Boolean {
        return email.isNotEmpty() && email.contains("@") && email.contains(".")
    }

    fun isPasswordValid(password: String): Boolean {
        return password.isNotEmpty()
    }
}