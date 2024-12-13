package com.example.myapplicationlast
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class CredentialsManagerTest {
    private val credentialsManager = CredentialsManager.instance

    @Test
    fun givenEmptyEmail_thenReturnFalse() {
        val isEmailValid = credentialsManager.isValidEmail("")

        assertFalse(isEmailValid)
    }

    @Test
    fun `test valid email format`() {
        assertTrue(credentialsManager.isValidEmail("test@example.com"))
        assertTrue(credentialsManager.isValidEmail("user123@gmail.com"))
        assertFalse(credentialsManager.isValidEmail("invalid-email"))
        assertFalse(credentialsManager.isValidEmail("user@com"))
        assertFalse(credentialsManager.isValidEmail(""))
    }

    @Test
    fun `test valid password`() {
        assertTrue(credentialsManager.isValidPassword("password123"))
        assertFalse(credentialsManager.isValidPassword("short"))
        assertFalse(credentialsManager.isValidPassword(""))
    }

    @Test
    fun testRegisterUser_addsToMap() {
        val result1 = credentialsManager.register("newuser1@example.com", "password123")
        assertEquals("Registration successful.", result1)

        val result2 = credentialsManager.register("newuser1@example.com", "password123")
        assertEquals("Error: Email is already registered.", result2)

        assertTrue(credentialsManager.isUserAlreadyRegistered("newuser1@example.com"))
    }

    @Test
    fun `test user already registered`() {
        // Assuming "user1@gmail.com" exists in the initial data
        assertTrue(credentialsManager.isUserAlreadyRegistered("user1@gmail.com"))
        assertFalse(credentialsManager.isUserAlreadyRegistered("newuser@gmail.com"))
    }

    @Test
    fun `test register new user successfully`() {
        val email = "newuser@gmail.com"
        val password = "securepassword"

        assertFalse(credentialsManager.isUserAlreadyRegistered(email))
        val result = credentialsManager.register(email, password)
        assertEquals("Registration successful.", result)
        assertTrue(credentialsManager.isUserAlreadyRegistered(email))
    }

    @Test
    fun `test register with already registered email`() {
        val email = "user1@gmail.com"
        val password = "newpassword"

        assertTrue(credentialsManager.isUserAlreadyRegistered(email))
        val result = credentialsManager.register(email, password)
        assertEquals("Error: Email is already registered.", result)
    }

    // Test invalid email format
    @Test
    fun givenWrongEmailFormat_thenReturnFalse() {
        val email = "wrongwqeformat.com"
        val isEmailValid = credentialsManager.isValidEmail(email)

        assertFalse(isEmailValid)
    }

    // Test valid email format
    @Test
    fun givenValidEmailFormat_thenReturnTrue() {
        val isEmailValid = credentialsManager.isValidEmail("test@example.com")

        assertTrue(isEmailValid)
    }

    // Test empty password
    @Test
    fun givenEmptyPassword_thenReturnFalse() {
        val isPasswordValid = credentialsManager.isValidPassword("")

        assertFalse(isPasswordValid)
    }

    // Test filled password
    @Test
    fun givenFilledPassword_thenReturnTrue() {
        val isPasswordValid = credentialsManager.isValidPassword("password123")

        assertTrue(isPasswordValid)
    }

    // Test for short password
    @Test
    fun givenShortPassword_thenReturnFalse() {
        val isPasswordValid = credentialsManager.isValidPassword("1234")

        assertFalse(isPasswordValid)
    }

    // Test for valid email format with edge case
    @Test
    fun givenEmail_thenReturnTrue() {
        val emailValid = credentialsManager.isValidEmail("test@te.st")

        assertTrue(emailValid)
    }
}
