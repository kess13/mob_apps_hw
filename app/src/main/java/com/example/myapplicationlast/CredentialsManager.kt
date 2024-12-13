package com.example.myapplicationlast

import android.util.Log

class CredentialsManager public constructor() {

    private val existingUsers = mutableMapOf<String, String>()

    // Singleton instance
    companion object {
        val instance: CredentialsManager by lazy { CredentialsManager() }
    }

    init {
        // Initialize with some dummy data
        existingUsers["user1@gmail.com"] = "password123"
        existingUsers["user2@tt.com"] = "password456"
        existingUsers["user3@test.com"] = "password789"
    }

    fun isValidEmail(email: String): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
        return email.isNotEmpty() && Regex(emailRegex).matches(email)
    }

    fun isValidPassword(password: String): Boolean {
        return password.isNotEmpty() && password.length >= 8
    }

    fun isUserAlreadyRegistered(email: String): Boolean {
        return existingUsers.containsKey(email)
    }

    fun register(email: String, password: String): String {
        if (isUserAlreadyRegistered(email)) {
            return "Error: Email is already registered."
        }
        existingUsers[email] = password
        return "Registration successful."
    }

    // To get the map of users
    fun getUsers(): Map<String, String> = existingUsers
}
