package com.example.myapplicationlast
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class CredentialsManagerTest {

    @Test
    fun givenEmptyEmail_thenReturnFalse() {
        val credentialsManager = CredentialsManager()

        val isEmailValid = credentialsManager.isValidEmail("")

        assertEquals(false, isEmailValid)
    }

    // Test invalid email format
    @Test
    fun givenWrongEmailFormat_thenReturnFalse() {
        val credentialsManager = CredentialsManager()
        val email = "wrongwqeformat.com"
        val isEmailValid = credentialsManager.isValidEmail(email)

        assertEquals(false, isEmailValid)
    }

    // Test valid email format
    @Test
    fun givenValidEmailFormat_thenReturnTrue() {
        val credentialsManager = CredentialsManager()

        val isEmailValid = credentialsManager.isValidEmail("test@example.com")

        assertEquals(true, isEmailValid)
    }

    // Test empty password
    @Test
    fun givenEmptyPassword_thenReturnFalse() {
        val credentialsManager = CredentialsManager()

        val isPasswordValid = credentialsManager.isValidPassword("")

        assertEquals(false, isPasswordValid)
    }

    // Test filled password
    @Test
    fun givenFilledPassword_thenReturnTrue() {
        val credentialsManager = CredentialsManager()

        val isPasswordValid = credentialsManager.isValidPassword("password123")

        assertEquals(true, isPasswordValid)
    }
    //test for email: test@te.st and
    //password: 1234
    @Test
    fun givenShortPassword_thenReturnFalse() {
        val credentialsManager = CredentialsManager()

        val isPasswordValid = credentialsManager.isValidPassword("1234")

        assertEquals(false, isPasswordValid)
    }

    @Test
    fun givenEmail_thenReturnTrue() {
        val credentialsManager = CredentialsManager()

        val email = credentialsManager.isValidEmail("test@te.st")

        assertEquals(true, email)
    }
}
